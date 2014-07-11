package com.diguage.books.thinking.io;

import com.diguage.books.thinking.util.Directory;

import java.io.File;
import java.io.IOException;

/**
 * 文件与目录遍历
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-09 16:22
 */
public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else {
                        if (!arg.endsWith("." + ext)) {
                            arg += "." + ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
            strategy.process(file);
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(args);
    }
}
