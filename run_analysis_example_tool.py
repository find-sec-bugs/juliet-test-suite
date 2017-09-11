#! /usr/bin/env/python 3.1
#
# Example that shows how to run an analysis with an example tool.
#
# This script uses the run_analysis method from py_common.  The run_analysis method
# script finds all the build.xml files and then passes them to the function defined
# in this file.
#
# In this case, we compile each CWE's testcases using the ant build.xml file.
#

import sys, re, os

# add parent directory to search path so we can use py_common
sys.path.append("..")

import py_common

def run_example_tool(build_xml_file):

	"""
	This method is called from the run_analysis method.  It is called for
	each matching file.  Files are matched against the glob expression
	specified in main.

	When this method is called, the script will have changed to the directory 
	where the build.xml file exists.
	"""
	
	# In order to run a source code analysis tool, build appropriate command
	# line(s) as shown in the commented out example below
	"""
	# retrieve the CWE # from the parent directory name
	path = os.getcwd()
	cwe_id = re.search("(CWE\d+)_", os.path.basename(path)).group(1)

	build_name = "toolname.java." + py_common.get_timestamp() + "." + cwe_id

	command1 = "mytool --build " + build_name + " --option1 --option2 " + build_xml_file

	py_common.print_with_timestamp("Running " + command1)
	py_common.run_commands([command1], True)

	command2 = "mytool --analyze " + build_name + " --output " + build_name + ".xml"

	py_common.print_with_timestamp("Running " + command2)
	py_common.run_commands([command2], True)
	"""
  
	# The code below will just run ant to compile the test cases without using a tool
	# Remove or comment out this code when modifying this file to use an analysis tool
	command = "ant"

	py_common.print_with_timestamp("Running " + command)
	py_common.run_commands([command], True)

if __name__ == '__main__':

	# Analyze the test cases
	py_common.run_analysis("src\\testcases", "build\.xml", run_example_tool)
