#!/bin/bash

#
#	github2pdf
#	a git2pdf wrapper for github
#

while getopts "u:n:" opt; do
  case $opt in
    u)
      user=$OPTARG
      ;;
    n)
      name=$OPTARG
      ;;
  esac
done

#run git2pdf with github extentions enabled
bash git2pdf.bash -g -r git://github.com/$user/$name.git
