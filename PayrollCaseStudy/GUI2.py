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

        self.homeButton = tkinter.Button(self.mainWindow, text = "Home", fg = "black", bg = "white",width = 15, command = self.displayHomeWindow)
        self.homeButton.grid(row = 0, column = 0,columnspan = 2)

        self.AddEditPayroll = tkinter.Button(self.mainWindow, text = "Add/Edit Payroll", fg = "black", bg = "white",width = 15, command = self.displayPayrollWindow)
        self.AddEditPayroll.grid(row = 0, column = 2, columnspan = 2)

        self.EmployeeDetailsButton = tkinter.Button(self.mainWindow, text = "Employee Details", fg = "black", bg = "white",width = 15, command = self.displayEmployeeDetailsWindow)
        self.EmployeeDetailsButton.grid(row = 0, column = 4, columnspan = 2)

        self.RunPayrollButton = tkinter.Button(self.mainWindow, text = "Run Payroll", fg = "black", bg = "white", width = 15,command = self.displayRunPayrollWindow)
        self.RunPayrollButton.grid(row = 0, column = 6)

        #create panels
        #home Panel
        self.DisplayPanelLeft = tkinter.Label(self.mainWindow, text = "News", bg = "white")

        self.DisplayPanelLeft.grid(column = 1, row = 1, columnspan = 5, rowspan = 5)


        #Payroll Add/Edit Panels
        self.SearchButton = tkinter.Button(self.mainWindow, text = "Search", bg = "white", width = 15)
        self.DataField = tkinter.Entry(self.mainWindow, bg = "white", width = 40)

        #Add/Edit Employee
        self.NewEmployeeButton = tkinter.Button(self.mainWindow, text = "New Employee", bg = "white", width = 15)
        self.EditEmployeeButton = tkinter.Button(self.mainWindow, text = "Edit", bg = "white", width = 15)

        #Run Payroll Window
        self.runPayrollButton = tkinter.Button(self.mainWindow, text = "Run Payroll", bg = "white", width = 15)

        self.message = tkinter.StringVar()
        self.mainWindow.mainloop()

    def clearWindow(self):
        self.DisplayPanelLeft.grid_forget()
        self.SearchButton.grid_forget()
        self.DataField.grid_forget()
        self.EditEmployeeButton.grid_forget()
        self.NewEmployeeButton.grid_forget()
        self.runPayrollButton.grid_forget()

    def displayHomeWindow(self):
        self.clearWindow()
        self.DisplayPanelLeft.grid(column = 1, row = 1, columnspan = 5, rowspan = 5)

    def displayPayrollWindow(self):
        self.clearWindow()
        self.SearchButton.grid(column =2, row = 3)
        self.DataField.grid(column = 4, row = 3, columnspan = 9)

    def displayEmployeeDetailsWindow(self):
        self.clearWindow()
        self.EditEmployeeButton.grid(column = 5, row = 3)
        self.NewEmployeeButton.grid(column = 3, row = 3)

    def displayRunPayrollWindow(self):
        self.clearWindow()
        self.runPayrollButton.grid(column = 2, row = 8)

run_gui = PayrollGui()

