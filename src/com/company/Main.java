package com.company;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class tr {

    public static void main(String[] args) throws IOException {
        List<Integer> arrList = Arrays.asList(ru.vsu.cs.util.ArrayUtils.readIntArrayFromFile("input.txt"));
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        double square = 0;
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0, n = arrList.size(); i < n; i += 6) {
            int x1 = arrList.get(i);
            int y1 = arrList.get(i + 1);
            int x2 = arrList.get(i + 2);
            int y2 = arrList.get(i + 3);
            int x3 = arrList.get(i + 4);
            int y3 = arrList.get(i + 5);
            double a = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
            double b = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
            double c = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
            square = 0;
            if (a + b <= c || a + c <= b || a + c <= b)
                System.out.println("Треугольник не существует");
            else {
                double p = ((a + b + c) / 2);
                square = Math.sqrt(p * (p - a) * (p - c) * (p - b));
                list.add(square);
            }
        }


        Collections.sort(list);
        for (double counter : list) {
            System.out.print("    ");
            System.out.print("Площадь треугольника: " + nf.format(counter));

        }
        writeListToFile("output "+' ', list);
    }
    public static void writeListToFile(String filename,List<Double> arrList) throws IOException {
        File file = new File(filename + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        for (int i = 0; i < arrList.size(); i++) {
            bw.write(nf.format(arrList.get(i)).toString() + "   ");


        }
        bw.flush();
        bw.close();
    }
}












