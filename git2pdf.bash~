#!/bin/bash

#
#	git2pdf
#	summarize the state of a git reposity in a pdf file
#	which is readable and printable
#

while getopts "r:g" opt; do
  case $opt in
    r)
      gitadress=$OPTARG
      ;;
	g)
	  github=true
	  ;;
  esac
done

#get repo
rm -rf repo
mkdir repo
cd repo
git clone $gitadress .

#provide files
cp ../java/Blamed2tex/bin/*.class ..
cp ../latex/template.tex ..

#for each file in repo
for file in $(find *); do
	#get authors
	git blame -c -l $file > ../blamed~

	#get additional infos
	git log --pretty=format:"%h%x09%an%x09%ad%x09%s\\\\" | head -n 5 > log.tex
	mv log.tex ..

	echo -e "$gitadress  \\\\  $file" >> vars.tex
	mv vars.tex ..
	cd ..

	#parse blame statements
	java Blamed2tex blamed~

	#make pdf	
	lualatex template.tex > /dev/null 2>&1
	bibtex template > /dev/null 2>&1
	lualatex template.tex > /dev/null 2>&1
	lualatex template.tex > /dev/null 2>&1

	#clean up
	mv template.pdf $(basename $file).pdf
	#mv bibliography.bib $(basename $file).bib
	rm content.tex vars.tex log.tex *.bib *.aux *.log *.out blamed~ *.bbl *.blg

	echo -e "$file.pdf created."

	cd repo
done

#concatenate pdf
#TODO stuff

#final clean up
cd ..
rm -rf repo
