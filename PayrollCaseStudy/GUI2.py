import tkinter

class PayrollGui:


    def __init__(self):
        #create main window
        self.mainWindow = tkinter.Tk()
        self.mainWindow.title("Simmar-Tech Payroll System")
        self.mainWindow.resizable(1,1)
        self.mainWindow.maxsize(width = 700,height = 500)
        self.mainWindow.minsize(width = 600, height = 400)
        self.mainWindow.configure(background = "white")
        #create buttons

        self.homeButton = tkinter.Button(self.mainWindow, text = "Home", fg = "black", bg = "white", command = self.displayHomeWindow)
        self.homeButton.grid(row = 0, column = 0,columnspan = 2)

        self.AddEditPayroll = tkinter.Button(self.mainWindow, text = "Add/Edit Payroll", fg = "black", bg = "white", command = self.displayPayrollWindow)
        self.AddEditPayroll.grid(row = 0, column = 2, columnspan = 2)

        self.EmployeeDetailsButton = tkinter.Button(self.mainWindow, text = "Employee Details", fg = "black", bg = "white", command = self.displayEmployeeDetailsWindow)
        self.EmployeeDetailsButton.grid(row = 0, column = 4, columnspan = 2)

        self.RunPayrollButton = tkinter.Button(self.mainWindow, text = "Run Payroll", fg = "black", bg = "white")
        self.RunPayrollButton.grid(row = 0, column = 6)

        #create panels
        #home Panel
        self.DisplayPanelLeft = tkinter.Label(self.mainWindow, text = "News", bg = "white")
        self.DisplayPanelRight = tkinter.Label(self.mainWindow, bg = "white", text = "Welcome to the Simmar-Teck Payroll System.\n You can use this payroll system \n to add "
        "new employees or edit \n existing employees."
        "You can edit and\n monitor your pay and run the payroll here.")#, textvariable = self.message)
        self.DisplayPanelLeft.grid(column = 1, row = 1, columnspan = 5, rowspan = 5)
        self.DisplayPanelRight.grid(column = 7, row = 5, columnspan = 5, rowspan = 5)

        #Payroll Panels
        self.SearchButton = tkinter.Button(self.mainWindow, text = "Search", bg = "white")
        self.DataField = tkinter.Entry(self.mainWindow, bg = "white")

        self.message = tkinter.StringVar()

        self.mainWindow.mainloop()

    def clearWindow(self):
        self.DisplayPanelRight.grid_forget()
        self.DisplayPanelLeft.grid_forget()
        self.SearchButton.grid_forget()
        self.DataField.grid_forget()

    def displayHomeWindow(self):
        self.clearWindow()
        self.DisplayPanelLeft.grid(column = 1, row = 1, columnspan = 5, rowspan = 5)
        self.DisplayPanelRight.grid(column = 7, row = 5, columnspan = 5, rowspan = 5)

    def displayPayrollWindow(self):
        self.clearWindow()

        self.SearchButton.grid(column =1, row = 1)

        self.DataField.grid(columnspan = 3, column = 2, row=1)

    def displayEmployeeDetailsWindow(self):
        self.clearWindow()



run_gui = PayrollGui()

