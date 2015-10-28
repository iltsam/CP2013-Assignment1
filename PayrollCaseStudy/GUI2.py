import tkinter
from tkinter import Listbox
from tkinter import *
from tkinter import ttk
class PayrollGui:

    def __init__(self):

        #create main window
        self.mainWindow = tkinter.Tk()
        self.mainWindow.title("Simmar-Tech Payroll System")
        self.mainWindow.resizable(1,1)
        self.mainWindow.maxsize(width = 900,height = 500)
        self.mainWindow.minsize(width = 700, height = 400)
        self.mainWindow.configure(background = "white")
        #create buttons

        self.homeButton = tkinter.Button(self.mainWindow, text = "Home", fg = "black", bg = "white",width = 25, command = self.displayHomeWindow)
        self.homeButton.grid(row = 0, column = 0,columnspan = 2)

        self.EmployeeDetailsButton = tkinter.Button(self.mainWindow, text = "Employee Details", fg = "black", bg = "white",width = 25, command = self.displayEmployeeDetailsWindow)
        self.EmployeeDetailsButton.grid(row = 0, column = 2, columnspan = 1)

        self.PayrollButton = tkinter.Button(self.mainWindow, text = "Payroll", fg = "black", bg = "white", width = 25,command = self.displayRunPayrollWindow)
        self.PayrollButton.grid(row = 0, column = 3, columnspan = 1)

        #create panels
        #home Panel
        self.newsPanel = tkinter.Label(self.mainWindow, text = "News", bg = "white")
        self.newsPanel.grid(column = 1, row = 1, columnspan = 5, rowspan = 5)
        #Add/Edit Employee Panels and field entries

        self.firstNameLabel = tkinter.Label(self.mainWindow, text='First Name:',width = 25)
        self.firstNameEntry = tkinter.Entry(self.mainWindow, text='First Name:',width = 25)

        self.middleNameLabel = tkinter.Label(self.mainWindow, text = 'Middle Names:',width = 25)
        self.middleNameEntry = tkinter.Entry(self.mainWindow, text = 'Middle Names:',width = 25)

        self.lastNameLabel= tkinter.Label(self.mainWindow, text = 'Last Name:', width = 25)
        self.lastNameEntry= tkinter.Entry(self.mainWindow, text = 'Last Name:', width = 25)

        self.genderLabel = tkinter.Label(self.mainWindow, text = 'Gender', width = 25)

        self.genderEntry = tkinter.Entry(self.mainWindow, width = 25)

        self.dateOfBirthLabel = tkinter.Label(self.mainWindow, text = 'Date of Birth', width = 25)
        self.dateOfBirthEntry = tkinter.Entry(self.mainWindow, text = 'Date of Birth', width = 25)

        self.addressLabel = tkinter.Label(self.mainWindow, text = 'Address', width = 25)
        self.addressEntry = tkinter.Entry(self.mainWindow, text = 'Address', width = 25)

        self.affiliationLabel = tkinter.Label(self.mainWindow,text = 'Affiliation', width = 25)
        self.affiliationEntry = tkinter.Entry(self.mainWindow,text = 'Affiliation', width = 25)

        self.classificationLabel = tkinter.Label(self.mainWindow, text = 'Classification', width = 25)
        self.classificationEntry = tkinter.Entry(self.mainWindow, text = 'Classification', width = 25)

        self.salaryLabel = tkinter.Label(self.mainWindow, text = 'Salary', width = 25)
        self.salaryEntry = tkinter.Entry(self.mainWindow, text = 'Salary', width = 25)

        self.hourlyRateLabel = tkinter.Label(self.mainWindow, text = 'Hourly Rate', width = 25)
        self.hourlyRateEntry = tkinter.Entry(self.mainWindow, text = 'Hourly Rate', width = 25)

        #Add/Edit Employee

        self.SearchButton = tkinter.Button(self.mainWindow, text = "Search", bg = "white", width = 25)
        self.DataField = tkinter.Entry(self.mainWindow, bg = "white", width = 60)
        self.addEmployeeButton = tkinter.Button(self.mainWindow, text = "Add Employee", bg = "white", width = 25)
        self.EditEmployeeButton = tkinter.Button(self.mainWindow, text = "Edit", bg = "white", width = 25)

        #List box
        self.employeeList = Listbox(self.mainWindow, width = 60, height = 10)
        self.payrollList = Listbox(self.mainWindow, width = 90, height = 20)
        #Run Payroll Window
        self.calculatePayButton = tkinter.Button(self.mainWindow, text = "Calculate Pay", bg = "white", width = 25)

        self.message = tkinter.StringVar()
        self.mainWindow.mainloop()


    def clearWindow(self):
        self.newsPanel.grid_forget()
        self.SearchButton.grid_forget()
        self.DataField.grid_forget()
        self.EditEmployeeButton.grid_forget()
        self.addEmployeeButton.grid_forget()
        self.calculatePayButton.grid_forget()
        self.employeeList.grid_forget()

        self.firstNameLabel.grid_forget()
        self.firstNameEntry.grid_forget()

        self.middleNameLabel.grid_forget()
        self.middleNameEntry.grid_forget()

        self.lastNameLabel.grid_forget()
        self.lastNameEntry.grid_forget()

        self.genderLabel.grid_forget()
        self.genderEntry.grid_forget()

        self.dateOfBirthLabel.grid_forget()
        self.dateOfBirthEntry.grid_forget()

        self.addressLabel.grid_forget()
        self.addressEntry.grid_forget()

        self.affiliationLabel.grid_forget()
        self.affiliationEntry.grid_forget()

        self.classificationLabel.grid_forget()
        self.classificationEntry.grid_forget()

        self.salaryLabel.grid_forget()
        self.salaryEntry.grid_forget()

        self.hourlyRateLabel.grid_forget()
        self.hourlyRateEntry.grid_forget()

        self.payrollList.grid_forget()

    def displayHomeWindow(self):
        self.clearWindow()
        self.newsPanel.grid(column = 1, row = 1, columnspan = 5, rowspan = 5)


    def displayEmployeeDetailsWindow(self):
        self.clearWindow()
        self.EditEmployeeButton.grid(column = 2, row = 6)
        self.addEmployeeButton.grid(column = 1, row = 6)
        self.SearchButton.grid(column =1, row = 2)
        self.DataField.grid(column = 2, row = 2,columnspan = 2)
        self.employeeList.grid(column =1,row = 3,columnspan = 2)

        self.firstNameLabel.grid(column = 1, row = 7)
        self.firstNameEntry.grid(column = 1, row = 8)

        self.middleNameLabel.grid(column =1, row = 9)
        self.middleNameEntry.grid(column = 1,row = 10)

        self.lastNameLabel.grid(column = 1, row = 11)
        self.lastNameEntry.grid(column = 1, row = 12)

        self.genderLabel.grid(column = 2, row = 7)
        self.genderEntry.grid(column = 2, row = 8)

        self.dateOfBirthLabel.grid(column = 2, row = 9)
        self.dateOfBirthEntry.grid(column = 2, row  = 10)

        self.affiliationLabel.grid(column = 2, row = 11)
        self.affiliationEntry.grid(column = 2, row = 12)

        self.classificationLabel.grid(column = 3, row = 7)
        self.classificationEntry.grid(column = 3, row = 8)

        self.salaryLabel.grid(column = 3, row = 9)
        self.salaryEntry.grid(column = 3, row = 10)

        self.hourlyRateLabel.grid(column= 3, row = 11)
        self.hourlyRateEntry.grid(column = 3, row = 12)

        self.addressLabel.grid(column = 1, row = 13)
        self.addressEntry.grid(column = 2, row = 13)



    def displayRunPayrollWindow(self):
        self.clearWindow()
        self.calculatePayButton.grid(column = 1, row = 7)
        self.payrollList.grid(column = 1, row = 6, columnspan = 4)

    #def editEmployee(self):


run_gui = PayrollGui()

