
# Setting PATH for Python 3.4
# The orginal version is saved in .bash_profile.pysave
PATH="/Library/Frameworks/Python.framework/Versions/3.4/bin:${PATH}"
export PATH

# Farbige Ordner-Listings
export CLICOLOR=1
 
# Legt die zu nutzenden Farben fest
export LSCOLORS=ExFxCxDxBxegedabagacad

# Entfernt doppelte Einträge aus der History
export HISTCONTROL=ignoredups

# Legt Textmate als Editor fest
export EDITOR="/Applications/Sublime\ Text.app/Contents/MacOS/Sublime\ Text"

# Ergänze das History-File anstatt ihn zu überschreiben
shopt -s histappend



#ABKUERZUNGEN
#alias swipl='/Applications/SWI-Prolog.app/Contents/MacOS/swipl'
alias profile='openst ~/.bash_profile'
alias programming='cd ~/Programming'
alias desk='cd ~/Desktop'
alias storage='df -h'
alias free='diskutil info / | grep "Free Space"'
# alias hpi='cd ~/Dropbox/Studium/HPI/'
# alias hpitab='newtab Studium hpi'
alias sublime-tips='printf "cmd+alt+number : multiwindow\ncmd+click : multicursor\n:number : go to line-number\ncmd+/ : comment\nsublimesnippet\n"'
alias sublimesnippet='open ~/Library/Application\ Support/Sublime\ Text\ 3/Packages/User/'
alias myIP='echo "intern:" && ipconfig getifaddr en0 && echo "extern:" && curl ipecho.net/plain; echo'

#Erstellt HTTP server aus aktuellem Ordner
alias easyHTTPServer='echo "IP:" && ipconfig getifaddr en0 && python -m SimpleHTTPServer'
alias simpleHTTPServer='easyHTTPServer'




alias subl='open -a /Applications/Sublime Text.app'
alias safe='open -a safari'
alias maile='open -a mail'





#FUNKTIONEN
tabname() {
  printf "\e]1;$1\a"
}

newtab() {
  TAB_NAME=$1
  COMMAND=$2
  osascript \
    -e "tell application \"Terminal\"" \
    -e "tell application \"System Events\" to keystroke \"t\" using {command down}" \
    -e "do script \"tabname $TAB_NAME; $COMMAND\" in front window" \
    -e "end tell" > /dev/null
}
#sublimeText(){
  #open -a /Applications/Sublime\ Text.app/ $1
#}

cs(){
    touch $1 && openst $1
}
openst(){
  open -a /Applications/Sublime\ Text.app/ $1
}

#DEFAULT-START
tabname Default
echo change settings using: profile
# ssh-add ~/.ssh/hpi &>/dev/null


# Add GHC 7.10.1 to the PATH, via https://ghcformacosx.github.io/
export GHC_DOT_APP="/Users/Philipp/Applications/ghc-7.10.1.app"
if [ -d "$GHC_DOT_APP" ]; then
  export PATH="${HOME}/.cabal/bin:${GHC_DOT_APP}/Contents/bin:${PATH}"
fi

