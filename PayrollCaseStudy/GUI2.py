import tkinter

class PayrollGui:


    def __init__(self):
        #create main window
        self.mainWindow = tkinter.Tk()
        self.mainWindow.title("Simmar-Tech Payroll System")
        self.mainWindow.resizable(1,1)
        self.mainWindow.maxsize(width = 700,height = 500)
        self.mainWindow.minsize(width = 600, height = 400)

        #create buttons

        self.homeButton = tkinter.Button(self.mainWindow, text = "Home", fg = "black")#,command = self.displayText)
        self.homeButton.grid(row = 0, column = 0,columnspan = 2)

        self.AddEditPayroll = tkinter.Button(self.mainWindow, text = "Add/Edit Payroll", fg = "black", command = self.displayPayrollWindow)
        self.AddEditPayroll.grid(row = 0, column = 2, columnspan = 2)

        self.EmployeeDetailsButton = tkinter.Button(self.mainWindow, text = "Employee Details", fg = "black")
        self.EmployeeDetailsButton.grid(row = 0, column = 4, columnspan = 2)

        self.RunPayrollButton = tkinter.Button(self.mainWindow, text = "Run Payroll", fg = "black")
        self.RunPayrollButton.grid(row = 0, column = 6, columnspan = 2)

        #create panels
        self.DisplayPanelLeft = tkinter.Label(self.mainWindow, text = "News")
        self.DisplayPanelLeft.grid(column = 1, row = 1, columnspan = 5, rowspan = 5)

        self.message = tkinter.StringVar()

        self.DisplayPanelRight = tkinter.Label(self.mainWindow, text = "Welcome to the Simmar-Teck Payroll System.\n You can use this payroll system \n to add "
        "new employees or edit \n existing employees."
        "You can edit and\n monitor your pay and run the payroll here.")#, textvariable = self.message)
        self.DisplayPanelRight.grid(column = 6, row = 1, columnspan = 5, rowspan = 5)
        self.mainWindow.mainloop()

    def displayPayrollWindow(self):
        self.SearchButton = tkinter.Button(self.mainWindow, text = "Search")
        self.SearchButton.grid(column =1, row = 1)
        self.DataField = tkinter.Entry(self.mainWindow)
        self.DataField.grid(columnspan = 3, column = 2, row=1)




run_gui = PayrollGui()

