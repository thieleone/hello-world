void my_cat(char *filename){
	FILE *fp;
	fp=fopen(filename,"r");//oder nur r
	if(NULL == fp) {
      printf("Konnte Datei nicht öffnen!\n");
	}
	else{
		char buffer[100];

		fread(buffer,fp);
		printf(buffer);
	}
}	

word, word, word
if (&c!=" "){
	if(word_check==0)
		++c_word;
		word_check=1;
}
else{
	word_check=0;
}