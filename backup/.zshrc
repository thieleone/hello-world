

#
# User configuration sourced by interactive shells
#

# Source zim
if [[ -s ${ZDOTDIR:-${HOME}}/.zim/init.zsh ]]; then
  source ${ZDOTDIR:-${HOME}}/.zim/init.zsh
fi




BASE16_SHELL=$HOME/.config/base16-shell/
[ -n "$PS1" ] && [ -s $BASE16_SHELL/profile_helper.sh ] && eval "$($BASE16_SHELL/profile_helper.sh)"


prompt oliver


export EDITOR="/Applications/Sublime\ Text.app/Contents/MacOS/Sublime\ Text"


alias programming='cd ~/Programming'
alias desk='cd ~/Desktop'


cs(){
    touch $1 && openst $1
}
openst(){
  open -a /Applications/Sublime\ Text.app/ $1
}