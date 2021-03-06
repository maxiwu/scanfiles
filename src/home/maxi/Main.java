package home.maxi;

import java.io.File;
import java.nio.file.Path;

import org.apache.commons.io.FilenameUtils;

public class Main {

	public static void main(String[] args) {
		// test list all folder in a drive
		File d_drive = new File("d:\\");
		if (d_drive.exists()) {
			listAllNestedDir(d_drive);
		}
	}

	private static void listAllNestedDir(File root) {
		if (root.exists() && root.canRead() && root.isDirectory()) {
			//System.out.println(root.getAbsolutePath());
			File[] files = root.listFiles();
			if (files != null) {				
				for (File f : files) {
					if (f.isDirectory()) {
						//System.out.println(f.getAbsolutePath());
						listAllNestedDir(f);
					}
					else{
						if(f.canRead())
						{
							String ext = FilenameUtils.getExtension(f.getName());
							if(ext.equals("mp3"))
							{
								System.out.println(f.getAbsolutePath());
							}
						}
					}
				}
			}
		}
	}

}
