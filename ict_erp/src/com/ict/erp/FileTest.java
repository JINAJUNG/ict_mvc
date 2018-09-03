package com.ict.erp;

import java.util.ArrayList;
import java.util.List;

class FileItem {
	private String name;
	private String string;

	public FileItem(String name, String string) {
		this.name = name;
		this.string = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "FileItem [name=" + name + ", string=" + string + "]";
	}

}

public class FileTest {
	public static List<FileItem> pares() {
		List<FileItem> fList = new ArrayList<FileItem>();
		FileItem fi = new FileItem("tmName","신과함께");
		fList.add(fi);
		fi = new FileItem("tcPrice", "20000");
		fList.add(fi);
		fi = new FileItem("tcDesc","원작 웹툰");
		fList.add(fi);
		return fList;
	}

	public static void main(String[] args) {
		List<FileItem> t = FileTest.pares();
		
		for(FileItem i : t) {
			if(i.getName().equals("tmName")) {
				System.out.println(i.getString());
			}
			System.out.println(i);
		}
	}
}
