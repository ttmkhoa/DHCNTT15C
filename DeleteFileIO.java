package example;

import java.io.File;

public class DeleteFileIO {
	private void deleteFile(String source) {
		//new file
		File file = new File(source);
		//check file exist
		// neu ton tai
		if(file.exists()) {
			System.out.println("file ton tai");
			file.delete();
			System.out.print("xoa file thanh cong");
		}
		else {
			System.out.println("file khong ton tai");
		}
	}
	
	public boolean deleteEmptyFolder(String source)
	{
		File folder = new File(source);
		//kiem tra neu folder ton tai thi xoa
		if(folder.exists())
		{
			folder.delete();
			System.out.println("folder ton tai\n xoa folder thanh cong");
			return true;
		}
		else
		{
			System.out.println("folder khong ton tai");
		}
		return false;		
	}
	
	
	public static void main(String[] args) {
		DeleteFileIO deleteFileIO = new DeleteFileIO();
		//deleteFileIO.deleteFile("D:/HocJava/demo.txt");
		deleteFileIO.deleteEmptyFolder("D:/HocJava/testFolder");
	}
}
