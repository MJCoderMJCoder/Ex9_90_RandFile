package com.randfile;

import java.io.IOException;
import java.io.RandomAccessFile;

class EmployeeRecord {
	int id;
	String name;
	double salary;
	EmployeeRecord(int i, String n, double s) { //构造方法
		id = i;
		name = n;
		salary = s;
	}
	
	public void read(RandomAccessFile file) throws IOException { //读一条记录
		id = file.readInt(); //读一个int型数据
		byte[] b = new byte[10]; //定义长度为10的字节数组b
		
		/*
		 * public final void readFully(byte[] b)throws IOException
		 * 从当前文件指针开始，将b.length个字节从文件读入byte数组
		 */
		file.readFully(b);  //从文件读10个字节到数组b中
		name = new String(b); //将b数组中的字节数据编码为字符串
		salary = file.readDouble(); //读一个double数据
	}
	
	public void write(RandomAccessFile file) throws IOException { //写一条记录
		file.writeInt(id); //写一个int数据
		byte [] b = new byte[10]; //定义长度为10的字节数组b
		if (name != null) {
			byte[] temp = name.getBytes(); //将字符串转换为字节数据存储在temp数组中
			
			/*
			 * System.arraycopy(src, srcPos, dest, destPos, length);
			 * 该方法可以将src源数组中从srcPos开始的连续length个元素复制到dest数组的从destPos开始位置，
			 * 且src和dest数组指向不同的内存空间
			 */
			System.arraycopy(temp, 0, b, 0, temp.length); //将temp数组复制到b数组
		}
		file.write(b); //将b数组中的10个字节数据写入文件
		file.writeDouble(salary); //写一个double数据
	}
	
	public int size() {
		return 22; //返回一个职工记录的长度（4+10+8=22Byte）
	}
	public int getId() {
		return id;
	}

	public void setId(int i) {
		id = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double s) {
		salary = s;
	}
	
	
}
