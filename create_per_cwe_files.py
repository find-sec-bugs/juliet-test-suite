#! /usr/bin/env/python 3.0
#
# Running this script will update the files in each CWE directory that 
# allow for building that CWE's test cases into a separate .war file.
#

import sys, os, shutil

# add parent directory to search path so we can use py_common
sys.path.append("..")

import py_common
import update_Main_java_ServletMain_java_and_web_xml

def help():
	sys.stderr.write('Usage: \n')
	sys.stderr.write('   create_per_cwe_files.py (builds per CWE files for all testcases)\n')
	sys.stderr.write('   create_per_cwe_files.py CWE (builds per CWE files for all testcases)\n')
	sys.stderr.write('   create_per_cwe_files.py CWE(78|15) (builds per CWE files for test cases for CWE 78 and CWE 15)')

if __name__ == "__main__":
	# check if ./src/testcases directory exists, if not, we are running
	# from wrong working directory
	if not os.path.exists("src\\testcases"):
		py_common.print_with_timestamp("Wrong working directory; could not find testcases directory")
		exit()
	
	# default value which is used if no arguments are passed on command line
	cwe_regex="CWE"

	if len(sys.argv) > 2:
		help()
		exit()

	if len(sys.argv) == 2:
		if (sys.argv[1] == '-h'):
			help()
			exit()

		cwe_regex = sys.argv[1]
	
	# get the CWE directories in testcases folder
	cwe_dirs = py_common.find_directories_in_dir("src\\testcases", cwe_regex)

	# only allow directories
	cwe_dirs = filter(lambda x: os.path.isdir(x), cwe_dirs)

	for dir in cwe_dirs:
		if 's01' in os.listdir(dir):
			is_dir_split = True
		else:
			is_dir_split = False
		
		if is_dir_split:
			# get the list of subdirectories
			cwe_sub_dirs = py_common.find_directories_in_dir(dir, "^s\d.*")
			
			for sub_dir in cwe_sub_dirs:
				# copy build.xml template into this testcase dir
				build_xml_template_file = "build.xml.split.template"
				build_xml_target_file = os.path.join(sub_dir, "build.xml")
				shutil.copy(build_xml_template_file, build_xml_target_file)

				# copy web.xml template into this testcase dir
				web_xml_template_file = "web.xml.template"
				web_xml_target_file = os.path.join(sub_dir, "web.xml")
				shutil.copy(web_xml_template_file, web_xml_target_file)

				# copy Main.java and ServletMain.java into this testcase dir
				main_java_target_files = os.path.join(sub_dir, "Main.java")
				shutil.copy("Main.java.template", main_java_target_files)
				servletmain_java_target_files = os.path.join(sub_dir, "ServletMain.java")
				shutil.copy("ServletMain.java.template", servletmain_java_target_files)

				# update all the files in this directory
				update_Main_java_ServletMain_java_and_web_xml.update_Main_java_ServletMain_java_and_web_xml(testcase_location=sub_dir, main_path=sub_dir, web_path=sub_dir)

		else:
			# copy build.xml template into this testcase dir
			build_xml_template_file = "build.xml.template"
			build_xml_target_file = os.path.join(dir, "build.xml")
			shutil.copy(build_xml_template_file, build_xml_target_file)

			# copy web.xml template into this testcase dir
			web_xml_template_file = "web.xml.template"
			web_xml_target_file = os.path.join(dir, "web.xml")
			shutil.copy(web_xml_template_file, web_xml_target_file)

			# copy Main.java and ServletMain.java into this testcase dir
			main_java_target_files = os.path.join(dir, "Main.java")
			shutil.copy("Main.java.template", main_java_target_files)
			servletmain_java_target_files = os.path.join(dir, "ServletMain.java")
			shutil.copy("ServletMain.java.template", servletmain_java_target_files)

			# update all the files in this directory
			update_Main_java_ServletMain_java_and_web_xml.update_Main_java_ServletMain_java_and_web_xml(testcase_location=dir, main_path=dir, web_path=dir)
