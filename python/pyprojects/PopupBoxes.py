import Tkinter
import tkMessageBox

top = Tkinter.Tk()
def hello():
    tkMessageBox.showinfo("Say Hello", "Hello World")

B1 = Tkinter.Button(top, text = "Say Hello", command = hello)
B1.pack()

top.mainloop()

# LARGE_FONT='Helvetica,12'
# MEDIUM_FONT='Helvetica,10'
# SMALL_FONT='Helvetica,8'
#
# def popupmsg(msg):
#     popup=tk.Tk()
#     popup.wm_title('!')
#     label=ttk.Label(popup,text=msg,font=MEDIUM_FONT)
#     label.pack(side='top',fill='x',pady=10)
#     Bl=tkk.Button(popup,text='OK',command=popup.destroy)
#     BL.pack()22
#     popup.mainloop()