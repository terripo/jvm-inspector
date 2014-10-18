package cn.hqm.jvm;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import cn.hqm.jvm.classfile.ClassFile;
import cn.hqm.jvm.classfile.ClassFileParser;
import cn.hqm.jvm.classfile.Displayer;


public class ClassFileParserTest {
    public static void parse(byte[] classBytes, File outfile) throws IOException {
        //byte[] classBytes = out.toByteArray();
        ClassFileParser parser = new ClassFileParser();
        ClassFile classFile = parser.parse(classBytes, null);
        Displayer displayer = new Displayer();
        classFile.display(displayer, classBytes);
        BufferedWriter bw = new BufferedWriter(new FileWriter(outfile));
        //bw.write("<style>.s1:hover{border-style:solid}</style>");
        bw.write(displayer.getHtml());
        bw.close();
    }


    public static void parseByByte() throws IOException {
        byte[] b = new byte[]{-54, -2, -70, -66, 0, 0, 0, 49, 0, 110, 1, 0, 3, 102, 36, 48, 1, 0, 82, 40, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 70, 114, 97, 109, 101, 59, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 84, 104, 114, 101, 97, 100, 83, 116, 97, 116, 101, 59, 41, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 79, 98, 106, 101, 99, 116, 59, 1, 0, 23, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 70, 114, 97, 109, 101, 7, 0, 3, 1, 0, 7, 115, 101, 116, 108, 105, 110, 101, 1, 0, 4, 40, 73, 41, 86, 12, 0, 5, 0, 6, 10, 0, 4, 0, 7, 1, 0, 23, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 112, 121, 99, 111, 100, 101, 47, 95, 112, 121, 120, 50, 7, 0, 9, 1, 0, 2, 95, 49, 1, 0, 26, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 83, 116, 114, 105, 110, 103, 59, 12, 0, 11, 0, 12, 9, 0, 10, 0, 13, 1, 0, 18, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 7, 0, 15, 1, 0, 7, 112, 114, 105, 110, 116, 108, 110, 1, 0, 29, 40, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 79, 98, 106, 101, 99, 116, 59, 41, 86, 12, 0, 17, 0, 18, 10, 0, 16, 0, 19, 1, 0, 7, 102, 95, 108, 97, 115, 116, 105, 1, 0, 1, 73, 12, 0, 21, 0, 22, 9, 0, 4, 0, 23, 1, 0, 4, 78, 111, 110, 101, 1, 0, 26, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 79, 98, 106, 101, 99, 116, 59, 12, 0, 25, 0, 26, 9, 0, 16, 0, 27, 1, 0, 6, 60, 105, 110, 105, 116, 62, 1, 0, 21, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 41, 86, 1, 0, 31, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 70, 117, 110, 99, 116, 105, 111, 110, 84, 97, 98, 108, 101, 7, 0, 31, 1, 0, 3, 40, 41, 86, 12, 0, 29, 0, 33, 10, 0, 32, 0, 34, 1, 0, 4, 115, 101, 108, 102, 1, 0, 25, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 112, 121, 99, 111, 100, 101, 47, 95, 112, 121, 120, 50, 59, 12, 0, 36, 0, 37, 9, 0, 10, 0, 38, 1, 0, 1, 98, 8, 0, 40, 1, 0, 24, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 83, 116, 114, 105, 110, 103, 7, 0, 42, 1, 0, 12, 102, 114, 111, 109, 73, 110, 116, 101, 114, 110, 101, 100, 1, 0, 46, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 41, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 83, 116, 114, 105, 110, 103, 59, 12, 0, 44, 0, 45, 10, 0, 43, 0, 46, 1, 0, 2, 95, 48, 1, 0, 84, 68, 58, 92, 49, 50, 95, 99, 111, 100, 101, 92, 97, 108, 105, 95, 121, 117, 110, 92, 115, 104, 97, 114, 101, 100, 92, 97, 99, 101, 52, 106, 92, 99, 111, 110, 116, 97, 105, 110, 101, 114, 92, 106, 97, 101, 92, 116, 114, 117, 110, 107, 92, 116, 111, 109, 99, 97, 116, 92, 106, 115, 116, 45, 100, 101, 118, 92, 119, 101, 98, 97, 112, 112, 115, 92, 82, 79, 79, 84, 92, 98, 46, 112, 121, 8, 0, 49, 12, 0, 48, 0, 12, 9, 0, 10, 0, 51, 1, 0, 24, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 67, 111, 100, 101, 59, 1, 0, 16, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 7, 0, 54, 1, 0, 8, 60, 109, 111, 100, 117, 108, 101, 62, 8, 0, 56, 1, 0, 7, 110, 101, 119, 67, 111, 100, 101, 1, 0, -97, 40, 73, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 73, 90, 90, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 70, 117, 110, 99, 116, 105, 111, 110, 84, 97, 98, 108, 101, 59, 73, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 73, 73, 41, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 67, 111, 100, 101, 59, 12, 0, 58, 0, 59, 10, 0, 16, 0, 60, 12, 0, 1, 0, 53, 9, 0, 10, 0, 62, 1, 0, 7, 103, 101, 116, 77, 97, 105, 110, 1, 0, 26, 40, 41, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 67, 111, 100, 101, 59, 1, 0, 4, 109, 97, 105, 110, 1, 0, 22, 40, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 41, 86, 8, 0, 9, 12, 0, 29, 0, 30, 10, 0, 10, 0, 69, 12, 0, 64, 0, 65, 10, 0, 10, 0, 71, 1, 0, 26, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 67, 111, 100, 101, 76, 111, 97, 100, 101, 114, 7, 0, 73, 1, 0, 21, 99, 114, 101, 97, 116, 101, 83, 105, 109, 112, 108, 101, 66, 111, 111, 116, 115, 116, 114, 97, 112, 1, 0, 57, 40, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 67, 111, 100, 101, 59, 41, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 67, 111, 100, 101, 66, 111, 111, 116, 115, 116, 114, 97, 112, 59, 12, 0, 75, 0, 76, 10, 0, 74, 0, 77, 1, 0, 7, 114, 117, 110, 77, 97, 105, 110, 1, 0, 53, 40, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 67, 111, 100, 101, 66, 111, 111, 116, 115, 116, 114, 97, 112, 59, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 41, 86, 12, 0, 79, 0, 80, 10, 0, 16, 0, 81, 1, 0, 16, 103, 101, 116, 67, 111, 100, 101, 66, 111, 111, 116, 115, 116, 114, 97, 112, 1, 0, 33, 40, 41, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 67, 111, 100, 101, 66, 111, 111, 116, 115, 116, 114, 97, 112, 59, 1, 0, 35, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 82, 117, 110, 110, 97, 98, 108, 101, 66, 111, 111, 116, 115, 116, 114, 97, 112, 7, 0, 85, 1, 0, 41, 103, 101, 116, 70, 105, 108, 101, 110, 97, 109, 101, 67, 111, 110, 115, 116, 114, 117, 99, 116, 111, 114, 82, 101, 102, 108, 101, 99, 116, 105, 111, 110, 66, 111, 111, 116, 115, 116, 114, 97, 112, 1, 0, 50, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 67, 108, 97, 115, 115, 59, 41, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 67, 111, 100, 101, 66, 111, 111, 116, 115, 116, 114, 97, 112, 59, 12, 0, 87, 0, 88, 10, 0, 86, 0, 89, 1, 0, 13, 99, 97, 108, 108, 95, 102, 117, 110, 99, 116, 105, 111, 110, 1, 0, 83, 40, 73, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 70, 114, 97, 109, 101, 59, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 84, 104, 114, 101, 97, 100, 83, 116, 97, 116, 101, 59, 41, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 79, 98, 106, 101, 99, 116, 59, 12, 0, 1, 0, 2, 10, 0, 10, 0, 93, 1, 0, 26, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 80, 121, 82, 117, 110, 110, 97, 98, 108, 101, 7, 0, 95, 1, 0, 32, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 109, 112, 105, 108, 101, 114, 47, 65, 80, 73, 86, 101, 114, 115, 105, 111, 110, 59, 1, 0, 5, 118, 97, 108, 117, 101, 3, 0, 0, 0, 33, 1, 0, 27, 76, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 109, 112, 105, 108, 101, 114, 47, 77, 84, 105, 109, 101, 59, 5, -1, -1, -1, -1, -1, -1, -1, -1, 1, 0, 27, 111, 114, 103, 47, 112, 121, 116, 104, 111, 110, 47, 99, 111, 114, 101, 47, 84, 104, 114, 101, 97, 100, 83, 116, 97, 116, 101, 7, 0, 103, 1, 0, 4, 67, 111, 100, 101, 1, 0, 15, 76, 105, 110, 101, 78, 117, 109, 98, 101, 114, 84, 97, 98, 108, 101, 1, 0, 8, 83, 116, 97, 99, 107, 77, 97, 112, 1, 0, 10, 83, 111, 117, 114, 99, 101, 70, 105, 108, 101, 1, 0, 25, 82, 117, 110, 116, 105, 109, 101, 86, 105, 115, 105, 98, 108, 101, 65, 110, 110, 111, 116, 97, 116, 105, 111, 110, 115, 0, 33, 0, 10, 0, 32, 0, 1, 0, 96, 0, 4, 0, 8, 0, 36, 0, 37, 0, 0, 0, 24, 0, 11, 0, 12, 0, 0, 0, 24, 0, 48, 0, 12, 0, 0, 0, 24, 0, 1, 0, 53, 0, 0, 0, 6, 0, 1, 0, 1, 0, 2, 0, 1, 0, 105, 0, 0, 0, 44, 0, 2, 0, 3, 0, 0, 0, 20, 43, 4, -74, 0, 8, -78, 0, 14, -72, 0, 20, 43, 2, -75, 0, 24, -78, 0, 28, -80, 0, 0, 0, 1, 0, 106, 0, 0, 0, 6, 0, 1, 0, 0, 0, 1, 0, 1, 0, 29, 0, 30, 0, 1, 0, 105, 0, 0, 0, 66, 0, 13, 0, 3, 0, 0, 0, 54, 42, -73, 0, 35, 42, -77, 0, 39, 18, 41, -72, 0, 47, -77, 0, 14, 18, 50, -72, 0, 47, -77, 0, 52, 3, 3, -67, 0, 55, 77, 44, 43, 18, 57, 3, 3, 3, -78, 0, 39, 3, 1, 1, 3, 17, 16, 0, -72, 0, 61, -77, 0, 63, -79, 0, 0, 0, 0, 0, 1, 0, 64, 0, 65, 0, 1, 0, 105, 0, 0, 0, 16, 0, 1, 0, 1, 0, 0, 0, 4, -78, 0, 63, -80, 0, 0, 0, 0, 0, 9, 0, 66, 0, 67, 0, 1, 0, 105, 0, 0, 0, 32, 0, 3, 0, 1, 0, 0, 0, 20, -69, 0, 10, 89, 18, 68, -73, 0, 70, -74, 0, 72, -72, 0, 78, 42, -72, 0, 82, -79, 0, 0, 0, 0, 0, 9, 0, 83, 0, 84, 0, 1, 0, 105, 0, 0, 0, 18, 0, 1, 0, 0, 0, 0, 0, 6, 18, 10, -72, 0, 90, -80, 0, 0, 0, 0, 0, 1, 0, 91, 0, 92, 0, 1, 0, 105, 0, 0, 0, 100, 0, 4, 0, 4, 0, 0, 0, 30, 42, 44, 45, 27, -86, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, -74, 0, 94, -80, 1, -80, 0, 0, 0, 1, 0, 107, 0, 0, 0, 52, 0, 2, 0, 24, 0, 4, 7, 0, 10, 1, 7, 0, 4, 7, 0, 104, 0, 3, 7, 0, 10, 7, 0, 4, 7, 0, 104, 0, 28, 0, 4, 7, 0, 10, 1, 7, 0, 4, 7, 0, 104, 0, 3, 7, 0, 10, 7, 0, 4, 7, 0, 104, 0, 2, 0, 108, 0, 0, 0, 2, 0, 49, 0, 109, 0, 0, 0, 20, 0, 2, 0, 97, 0, 1, 0, 98, 73, 0, 99, 0, 100, 0, 1, 0, 98, 74, 0, 101};
        OutputStream out = new FileOutputStream(new File("bytes.class"));
        out.write(b);
        out.flush();
        out.close();
        parse(b, new File("bytes.html"));
    }


    public static void parseByFile(File file) throws IOException {
        //String dir = "D:/12_code/tae/trunk/tae-jvm-inspect/target/test-classes/com/taobao/tae/jvm";
        //File file = new File(dir, "TypicalClass1.class");
        //File file = new File(dir, "TypicalClass1$MyException.class");
        //File file = new File(dir, "NotAMember.class");
        //File file = new File(dir, "WideInstructionTest.class");


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        byte[] b = new byte[1024];
        int len;
        while ((len = in.read(b)) >= 0) {
            out.write(b, 0, len);
        }
        in.close();

        byte[] classBytes = out.toByteArray();
        parse(classBytes, new File(file.getAbsoluteFile() + ".html"));
    }


    public static void main(String[] args) throws IOException {
        //parseByByte();
        
        //String dir = "D:/12_code/tae/trunk/tae-php-engine/resin-quercus4036/phpclasses";
        //File file = new File(dir, "languagereference.include.include_vars_dynamic_php4j.class");
        File file = new File("D:/12_code/tae/trunk/tae-php-engine/playground/bytecode-playground/target/classes/com/schlimm/bytecode/VarArgsParameterDynamicInvoker.class");
        parseByFile(file);
    }

}