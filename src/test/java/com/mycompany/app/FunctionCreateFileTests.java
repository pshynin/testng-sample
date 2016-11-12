package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by pshynin on 11/8/16.
 */
public class FunctionCreateFileTests extends TestBase {
  final Path path;

  @BeforeMethod
  public void createTempDirectory() {
    try {
      path = Files.createTempDirectory("amberdb");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public Path getPath() {
    return path;
  }

  @Test
  public void testDirectoryPresent() {
      File testDirectory = new File(".");
      System.out.println(testDirectory.getAbsolutePath());
      File file = new File("resources/test.txt");
      System.out.println(file.getAbsolutePath());
      System.out.println(file.exists());
    }

  @Test
  public void fileCretionTest() {

    File file = null;
    boolean bool = false;

    try {
      file = new File("resources/test.txt");
      bool = file.createNewFile();
      System.out.println("File created: " + bool);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void fileDeletionTest() {
    File file = null;
    boolean bool = false;

    try {
      file = new File("resources/test.txt");
      file.delete();
      System.out.println("delete() method is invoked");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void badFileCretionTest() {
    System.out.println("@Test : validateDifference()");
    int a = 5;
    int b = 10;
    Assert.assertEquals(b - a, 5);
  }

  public void bedFileDeletionTest() {
    System.out.println("@Test : validateDifference()");
    int a = 5;
    int b = 10;
    Assert.assertEquals(b - a, 5);
  }

  @AfterMethod(alwaysRun = true)
          Runtime.getRuntime().addShutdownHook(new Thread() {
    @Override
    public void run() {
      delete();
    }
  });
}

  public void delete() {
    if (!Files.exists(path)) {
      return;
    }
    try {
      Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                throws IOException {
          Files.deleteIfExists(dir);
          return super.postVisitDirectory(dir, exc);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                throws IOException {
          Files.deleteIfExists(file);
          return super.visitFile(file, attrs);
        }
      });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

