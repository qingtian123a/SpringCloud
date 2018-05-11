package com.kay.common.Tools;

import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 * @Author kay
 * @Data 2018/5/10 13:56
 */
public class FtpUtil {

    private static final String url="10.39.30.19";
    private static final Integer port=22;
    private static final String username="ftpuser";
    private static final String password="ftp@fn29";
    private static final String fileUrl="/data/pictures";

    private static JSch jsch;
    private static Session session;
    /** 对外可访问 ChannelSftp对象提供的所有底层方法*/
    private static ChannelSftp chnSftp;

    private static void connectFtp(){

        try {
            jsch = new JSch();
            session = jsch.getSession(username, url);
            session.setPassword(password);

            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            session.setConfig(sshConfig);
            session.connect();
            //System.out.println("Session connected.");
            Channel channel = session.openChannel("sftp");
            //System.out.println("Channel is Opened!");
            channel.connect();
            chnSftp = (ChannelSftp) channel;

        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getUrls(String stationId){
        connectFtp();

        List<String> urls=new ArrayList<>();
        try {
            //获取所有目录
            Vector<ChannelSftp.LsEntry> ls = chnSftp.ls(fileUrl + "/" + stationId);
            for(int i=0;i<ls.size();i++){
                ChannelSftp.LsEntry lsEntry = ls.elementAt(i);
                String filename = lsEntry.getFilename();
                System.out.println(filename);
                if (!filename.equals(".") && !filename.equals("..")) {
                    //获取每个目录下面的图片
                    Vector<ChannelSftp.LsEntry> ls1 = chnSftp.ls(fileUrl + "/" + stationId + "/" + filename);
                    for(int j=0;j<ls1.size();j++) {
                        ChannelSftp.LsEntry lsEntry1 = ls1.elementAt(j);
                        String filename1 = lsEntry1.getFilename();
                        System.out.println(filename1);
                        if (!filename1.equals(".") && !filename1.equals("..")) {
                            urls.add(filename + "/" + filename1);
                        }
                    }
                }
            }


        } catch (SftpException e) {
            e.printStackTrace();
        }finally {
            session.disconnect();
            chnSftp.disconnect();
        }

        return urls;
    }

    /*****************文件处理**************/

    /**
     * 连接sftp服务器
     * @param host 主机
     * @param port 端口
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public ChannelSftp connect(String host, int port, String username,
                               String password) {
        ChannelSftp sftp = null;
        try {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            Session sshSession = jsch.getSession(username, host, port);
            System.out.println("Session created.");
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            System.out.println("Session connected.");
            System.out.println("Opening Channel.");
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            System.out.println("Connected to " + host + ".");
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        return sftp;
    }


    /**
     * 上传文件
     * @param directory 上传的目录
     * @param uploadFile 要上传的文件
     * @param sftp
     */
    public void upload(String directory, String uploadFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            File file=new File(uploadFile);
            sftp.put(new FileInputStream(file), file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载文件
     * @param directory 下载目录
     * @param downloadFile 下载的文件
     * @param saveFile 存在本地的路径
     * @param sftp
     */
    public void download(String directory, String downloadFile,String saveFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            File file=new File(saveFile);
            sftp.get(downloadFile, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     * @param directory 要删除文件所在目录
     * @param deleteFile 要删除的文件
     * @param sftp
     */
    public void delete(String directory, String deleteFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 列出目录下的文件
     * @param directory 要列出的目录
     * @param sftp
     * @return
     * @throws SftpException
     */
    @SuppressWarnings("unchecked")
    public Vector<ChannelSftp.LsEntry> listFiles(String directory, ChannelSftp sftp) throws SftpException{
        return sftp.ls(directory);
    }


    public static void main(String[] args) {
        connectFtp();
        List<String> urls = getUrls("CA01ES01");
        System.out.println(urls.size());
        session.disconnect();
        chnSftp.disconnect();


//      ChannelSftp  sftp = connect(host, port, username, password); //获取连接
//
//      //upload(directory, uploadFile, sftp);   //上传文件
//
//      download(directory, downloadFile, saveFile, sftp);  //删除文件

        //  delete(directory, deleteFile, sftp); //删除文件

        //      Vector<LsEntry> files = listFiles(directory, sftp);        //查看文件列表
        //      for (LsEntry file : files) {
        //          System.out.println(file.getFilename());
        //      }

    }

}
