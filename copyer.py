import csv
try:
    import mysql.connector as q 
except :
    import subprocess
    subprocess.run(['pip', 'install', 'mysql-connector-python'])

# Main function
def main():
    import mysql.connector as q 
    try:
        import mysql.connector as q 
        d = q.connect(host="localhost", user="root", password="abhishek@1604", database="flightrecord")
        conn = d.cursor()
        
        with open('generated_flight_data.csv', 'r', newline='') as file:
            reader = csv.reader(file)
            i = 0
            for row in reader:
                if i != 0:
                    print(row)
                    print(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], row[10], row[11], row[12])
                    conn.execute("INSERT INTO flightdetails (PlaneId, PlaneModel, FromAir, FromDate, FromTime, ToAir, ToDate, ToTime, FlightDuration, LuggageAllowed, Economy, Business, FirstClass) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", (row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], row[10], row[11], row[12]))
                    d.commit()
                i += 1
        
        print("Data copied from CSV to MySQL database successfully.")
        conn.close() 
    except Exception as e:
        print("An error occurred:", e)

if __name__ == "__main__":
    main()

