package vw.util;


import java.io.*;
import java.util.List;

/**
 * Created by like on 2015/3/4.
 */
public class ConvertFlv {

    public static boolean convert(String inputFile, String outputFile,String newimg,String realPath)
    {
        if (!checkfile(inputFile)) {
            System.out.println(inputFile + " is not file");
            return false;
        }
        if (process(inputFile,outputFile,newimg,realPath)) {
            System.out.println("ok");
            return true;
        }
        return false;
    }

    private static boolean checkfile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        }
        return true;
    }

    private static boolean process(String inputFile,String outputFile,String newimg,String realPath) {
        int type = checkContentType(inputFile);
        boolean status = false;
        if (type == 0) {
            String inputType = inputFile.substring(inputFile.lastIndexOf(".") + 1, inputFile.length()).toLowerCase();
            if(inputType.equals("flv")){
                processImg(inputFile, newimg,realPath);
                System.out.println("图片生成完成！！");
            }else{
                processImg(inputFile, newimg,realPath);
                status = true;
                //status = processFLV(inputFile,outputFile,newimg,realPath);// 直接将文件转为flv文件
                System.out.println("直接转型后图片生成完成！");
            }
        } else if (type == 1) {
            String avifilepath = processAVI(type,inputFile,realPath);
            if (avifilepath == null)
                return false;// avi文件没有得到
            status = processFLV(avifilepath,outputFile,newimg,realPath);// 将avi转为flv
            processImg(inputFile, newimg,realPath);
        }
        System.out.println("================status:"+status);
        return status;
    }

    private static int checkContentType(String inputFile) {
        String type = inputFile.substring(inputFile.lastIndexOf(".") + 1, inputFile.length()).toLowerCase();
// ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi")) {
            return 0;
        } else if (type.equals("mpg")) {
            return 0;
        } else if (type.equals("wmv")) {
            return 0;
        } else if (type.equals("3gp")) {
            return 0;
        } else if (type.equals("mov")) {
            return 0;
        } else if (type.equals("mp4")) {
            return 0;
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        }
// 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
// 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
        //mencoder已经包含进来也可以转换了
        else if (type.equals("wmv9")) {
            return 1;
        } else if (type.equals("rm")) {
            return 1;
        } else if (type.equals("rmvb")) {
            return 1;
        }
        return 9;
    }

    private static boolean processFLV(String inputFile,String outputFile,String newimg,String realPath) {
        if (!checkfile(inputFile)) {
            System.out.println(inputFile + " is not file");
            return false;
        }

        List<String> commend = new java.util.ArrayList<String>();
//低精度
        commend.add(realPath+"\\ffmpeg.exe");
        commend.add("-i");
        commend.add(inputFile);
        commend.add("-ab");
        commend.add("128");
        commend.add("-acodec");
        commend.add("libmp3lame");
        commend.add("-ac");
        commend.add("1");
        commend.add("-ar");
        commend.add("22050");
        commend.add("-r");
        commend.add("29.97");
//高精度   将-b 512 修改成-qscale 6
// commend.add("-qscale");
// commend.add("6");
        commend.add("-b");
        commend.add("512");
        commend.add("-y");
        commend.add(outputFile);
        StringBuffer test=new StringBuffer();
        for(int i=0;i<commend.size();i++)
            test.append(commend.get(i)+" ");
        System.out.println(test);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            Process p = builder.start();
            //doWaitFor(p);
            p.destroy();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String processAVI(int type,String inputFile,String realPath) {
        String name = inputFile.substring(0,inputFile.lastIndexOf("."))+".avi";
        File file =new File(name);
        if(file.exists())
            file.delete();
        List<String> commend = new java.util.ArrayList<String>();
        commend.add(realPath+"\\"+"mencoder.exe");
        commend.add(inputFile);
        commend.add("-oac");
        commend.add("mp3lame");
        commend.add("-lameopts");
        commend.add("preset=64");
        commend.add("-ovc");
        commend.add("xvid");
        commend.add("-xvidencopts");
        commend.add("bitrate=1000");
        commend.add("-of");
        commend.add("avi");
        commend.add("-o");
        commend.add(name);
        StringBuffer test=new StringBuffer();
        for(int i=0;i<commend.size();i++)
            test.append(commend.get(i)+" ");
        System.out.println(test);
        try
        {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            Process p = builder.start();
            doWaitFor(p);
/**
 * 清空Mencoder进程 的输出流和错误流
 * 因为有些本机平台仅针对标准输入和输出流提供有限的缓冲区大小，
 * 如果读写子进程的输出流或输入流迅速出现失败，则可能导致子进程阻塞，甚至产生死锁。
 */
            return name;
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public static boolean processImg(String inputFile,String newimg,String realPath){
        boolean flag = false;
        List<String> commend = new java.util.ArrayList<String>();
        commend.add(realPath+"\\ffmpeg.exe");
        commend.add("-i");
        commend.add(inputFile);
        commend.add("-y");
        commend.add("-f");
        commend.add("image2");
        commend.add("-ss");
        commend.add("10");
        commend.add("-t");
        commend.add("0.020");
        commend.add("-s");
        commend.add("220x150");
        commend.add(newimg);

        StringBuffer test=new StringBuffer();
        for(int i=0;i<commend.size();i++)
            test.append(commend.get(i)+" ");
        System.out.println("图片生成命令："+test.toString());
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(commend);
        try {
            Process p = builder.start();
            flag = true;
            //doWaitFor(p);
            //p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public static int doWaitFor(Process p) {
        InputStream in = null;
        InputStream err = null;
        int exitValue = -1; // returned to caller when p is finished
        try {
            System.out.println("comeing");
            in = p.getInputStream();
            err = p.getErrorStream();
            boolean finished = false; // Set to true when p is finished

            while (!finished) {
                try {
                    while (in.available() > 0) {
                        Character c = new Character((char) in.read());
                        System.out.print(c);
                    }
                    while (err.available() > 0) {
                        Character c = new Character((char) err.read());
                        System.out.print(c);
                    }

                    exitValue = p.exitValue();
                    finished = true;

                } catch (IllegalThreadStateException e) {
                    Thread.currentThread().sleep(500);
                }
            }
        } catch (Exception e) {
            System.err.println("doWaitFor();: unexpected exception - "
                    + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            if (err != null) {
                try {
                    err.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return exitValue;
    }
}
