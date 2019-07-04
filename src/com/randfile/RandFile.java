package com.randfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandFile {

	public static void main(String[] args) {
		RandomAccessFile file;
		EmployeeRecord e1 = new EmployeeRecord(1001, "����", 5678.50);
		EmployeeRecord e2 = new EmployeeRecord(1002, "����", 6758.60);
		EmployeeRecord e3 = new EmployeeRecord(1003, "����", 5867.70);
		EmployeeRecord e4 = new EmployeeRecord(1004, "����", 7865.80);
		EmployeeRecord emp = new EmployeeRecord(0, "", 0.0);
		
		try {
			file = new RandomAccessFile("Employee.dat", "rw"); //������ļ�
			e1.write(file); //ְ������e1�����ݼ�¼д���ļ�
			e2.write(file); //������������ļ���д��3����¼
			e3.write(file);
			file.seek(1*emp.size()); //�ƶ��ļ���дָ�뵽��2����¼
			emp.read(file); //����2����¼������emp�У�ָ���3����¼
			emp.setName("����"); //�޸Ķ���emp������
			file.seek(1*emp.size()); //�ƶ��ļ���дָ���ٴε���2����¼
			emp.write(file); //����emp�е������ٴ�д���ļ�����2����¼�������޸�
			file.seek(file.length()); //�ƶ��ļ���дָ�����ļ�β
			e4.write(file); //���ļ�βд��ְ������e4�����ݼ�¼
			file.seek(0); //�ƶ��ļ���дָ�����ļ���ʼ
			
			/*
			 * public long getFilePointer() throws IOException
			 * ����[���ļ���ͷ��ƫ���������ֽ�Ϊ��λ��]���ڸ�λ�÷�����һ����ȡ��д�����
			 */
			while (file.getFilePointer() < file.length()) { //����ļ��е���������
				emp.read(file);
				System.out.println(emp.getId() + "  " + emp.getName() + " " + emp.getSalary());
			}
			file.close(); //�ر��ļ�
		} catch (IOException e) {
			System.out.println("�ļ��򿪻�д�ļ�����ļ�ʧ�ܣ�" + e.toString());
			
			/*
			 * ǿ����ֹ��ǰ�������е�java�����������������Ϣ���ظ�ϵͳ
			 * ������Ϊ0����ʾ������ֹ������Ϊ0����ʾ�쳣��ֹ
			 */
			System.exit(1);
		}
	}

}
