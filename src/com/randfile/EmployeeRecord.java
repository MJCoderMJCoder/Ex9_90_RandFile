package com.randfile;

import java.io.IOException;
import java.io.RandomAccessFile;

class EmployeeRecord {
	int id;
	String name;
	double salary;
	EmployeeRecord(int i, String n, double s) { //���췽��
		id = i;
		name = n;
		salary = s;
	}
	
	public void read(RandomAccessFile file) throws IOException { //��һ����¼
		id = file.readInt(); //��һ��int������
		byte[] b = new byte[10]; //���峤��Ϊ10���ֽ�����b
		
		/*
		 * public final void readFully(byte[] b)throws IOException
		 * �ӵ�ǰ�ļ�ָ�뿪ʼ����b.length���ֽڴ��ļ�����byte����
		 */
		file.readFully(b);  //���ļ���10���ֽڵ�����b��
		name = new String(b); //��b�����е��ֽ����ݱ���Ϊ�ַ���
		salary = file.readDouble(); //��һ��double����
	}
	
	public void write(RandomAccessFile file) throws IOException { //дһ����¼
		file.writeInt(id); //дһ��int����
		byte [] b = new byte[10]; //���峤��Ϊ10���ֽ�����b
		if (name != null) {
			byte[] temp = name.getBytes(); //���ַ���ת��Ϊ�ֽ����ݴ洢��temp������
			
			/*
			 * System.arraycopy(src, srcPos, dest, destPos, length);
			 * �÷������Խ�srcԴ�����д�srcPos��ʼ������length��Ԫ�ظ��Ƶ�dest����Ĵ�destPos��ʼλ�ã�
			 * ��src��dest����ָ��ͬ���ڴ�ռ�
			 */
			System.arraycopy(temp, 0, b, 0, temp.length); //��temp���鸴�Ƶ�b����
		}
		file.write(b); //��b�����е�10���ֽ�����д���ļ�
		file.writeDouble(salary); //дһ��double����
	}
	
	public int size() {
		return 22; //����һ��ְ����¼�ĳ��ȣ�4+10+8=22Byte��
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
