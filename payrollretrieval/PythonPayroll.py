import sqlite3

# create new db and make connection
conn = sqlite3.connect('my_dba.db')
c = conn.cursor()



# create table
#c.execute('''CREATE TABLE my_db
#             (id TEXT, my_var1 TEXT, my_var2 INT)''')

mystuff = c.execute('''SELECT DISTINCT * FROM my_db''')

for stuff in mystuff:
    print(stuff)

# insert one row of data
#c.execute("INSERT INTO my_db VALUES ('ID_2352532','YES', 4)")

# insert multiple lines of data
#multi_lines =[ ('ID_2352533','YES', 1),
 #              ('ID_2352534','NO', 0),
  #             ('ID_2352535','YES', 3),
   #            ('ID_2352536','YES', 9),
    #           ('ID_2352537','YES', 10)
     #         ]
#c.executemany('INSERT INTO my_db VALUES (?,?,?)', multi_lines)

# save (commit) the changes
conn.commit()

# close connection
conn.close()