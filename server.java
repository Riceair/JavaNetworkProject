import java.io.*;
import java.net.*;


public class server
{
    public final static int PORT=20;
    public static void main(String args[])
    {

        int p1checkflag=0,p2checkflag=0,nump1=0,nump2=0,checknum=0,p1startflag=0,p2startflag=0;
        int p1checknum=1,p2checknum=2,startnum=3;


        try(ServerSocket server=new ServerSocket(PORT))
        {
            while(true)
            {
                try {

                    Socket connect=server.accept();
                    System.out.println("connect");
                    BufferedOutputStream out=new BufferedOutputStream(connect.getOutputStream());
                    BufferedInputStream in=new BufferedInputStream(connect.getInputStream());

                    if(p1checkflag==0||p2checkflag==0)
                    {
                        checknum=in.read();
                        if(checknum!=0)
                        {
                            System.out.println("get out");
                            out.write(checknum);
                            out.flush();
                            connect.shutdownOutput();
                        }
                        else
                        {
                            if(p1checkflag==0)
                            {
                                p1checkflag=1;
                                out.write(p1checknum);
                                out.flush();
                            }
                            else
                            {
                                p2checkflag=1;
                                out.write(p2checknum);
                                out.flush();
                            }

                            connect.shutdownOutput();
                        }
                    }

                    else
                    {
                        if(p1startflag==0||p2startflag==0)
                        {
                            checknum=in.read();
                            if(checknum==1)
                            {
                                p1startflag=1;
                                out.write(startnum);
                                out.flush();
                            }
                            else
                            {
                                p2startflag=1;
                                out.write(startnum);
                                out.flush();
                            }
                            connect.shutdownOutput();
                        }
                        else
                        {

                            checknum=in.read();
                            if(checknum==1)
                            {
                                nump1=checknum;

                            }
                            else
                            {
                                nump2=checknum;

                            }

                            Thread task=new ServerThread(connect,nump1,nump2,checknum);
                            task.start();

                        }
                    }


                }
                catch(java.io.IOException e){
                    System.out.println("have problem!");
                }
            }
        }
        catch(java.io.IOException e)
        {
            System.out.println("have problem!");
        }
    }


    private static class ServerThread extends Thread{
        private Socket connect;
        private int nump1=0,nump2=0,checknum=0;

        ServerThread(Socket connect,int nump1,int nump2,int checknum)
        {
            this.connect=connect;
            this.nump1=nump1;
            this.nump2=nump2;
            this.checknum=checknum;
        }

        public void run()
        {
            try {

                BufferedOutputStream out=new BufferedOutputStream(connect.getOutputStream());

                if(checknum==1)
                {

                    out.write(nump2);
                    out.flush();
                }
                else
                {

                    out.write(nump1);
                    out.flush();
                }

            }
            catch(java.io.IOException e)
            {
                System.out.println("have problem!");
            }

            finally {
                try {
                    connect.shutdownOutput();
                }
                catch(java.io.IOException e)
                {
                    System.out.println("have problem!");
                }
            }
        }
    }


}

