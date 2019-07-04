package com.randfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandFile {

	public static void main(String[] args) {
		RandomAccessFile file;
		EmployeeRecord e1 = new EmployeeRecord(1001, "张三", 5678.50);
		EmployeeRecord e2 = new EmployeeRecord(1002, "李四", 6758.60);
		EmployeeRecord e3 = new EmployeeRecord(1003, "王五", 5867.70);
		EmployeeRecord e4 = new EmployeeRecord(1004, "赵六", 7865.80);
		EmployeeRecord emp = new EmployeeRecord(0, "", 0.0);
		
		try {
			file = new RandomAccessFile("Employee.dat", "rw"); //打开随机文件
			e1.write(file); //职工对象e1的数据记录写入文件
			e2.write(file); //先依次向随机文件中写入3条记录
			e3.write(file);
			file.seek(1*emp.size()); //移动文件读写指针到第2个记录
			emp.read(file); //读第2条记录到对象emp中，指向第3个记录
			emp.setName("李宁"); //修改对象emp的姓名
			file.seek(1*emp.size()); //移动文件读写指针再次到第2个记录
			emp.write(file); //对象emp中的数据再次写入文件，第2条记录姓名被修改
			file.seek(file.length()); //移动文件读写指针至文件尾
			e4.write(file); //在文件尾写入职工对象e4的数据记录
			file.seek(0); //移动文件读写指针至文件开始
			
			/*
			 * public long getFilePointer() throws IOException
			 * 返回[到文件开头的偏移量（以字节为单位）]，在该位置发生下一个读取或写入操作
			 */
			while (file.getFilePointer() < file.length()) { //输出文件中的所有数据
				emp.read(file);
				System.out.println(emp.getId() + "  " + emp.getName() + " " + emp.getSalary());
			}
			file.close(); //关闭文件
		} catch (IOException e) {
			System.out.println("文件打开或写文件或读文件失败：" + e.toString());
			
			/*
			 * 强制终止当前正在运行的java虚拟机，并将参数信息返回给系统
			 * 若参数为0，表示正常终止；若不为0，表示异常终止
			 */
			System.exit(1);
		}
	}

}
