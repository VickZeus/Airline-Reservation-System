import csv
import random
import datetime

# Function to generate a random Indian airport
def get_random_indian_airport():
    indian_airports = [
        ['DEL', 'Indira Gandhi International Airport', 'New Delhi'],
        ['BOM', 'Chhatrapati Shivaji Maharaj International Airport', 'Mumbai'],
        ['BLR', 'Kempegowda International Airport', 'Bangalore'],
        ['MAA', 'Chennai International Airport', 'Chennai'],
        ['CCU', 'Netaji Subhas Chandra Bose International Airport', 'Kolkata'],
        ['HYD', 'Rajiv Gandhi International Airport', 'Hyderabad'],
        ['AMD', 'Sardar Vallabhbhai Patel International Airport', 'Ahmedabad'],
        ['PNQ', 'Pune Airport', 'Pune'],
        ['GOI', 'Dabolim Airport', 'Goa'],
        ['COK', 'Cochin International Airport', 'Kochi'],
        ['IXC', 'Chandigarh Airport', 'Chandigarh'],
        ['JAI', 'Jaipur International Airport', 'Jaipur'],
        ['VGA', 'Vijayawada International Airport', 'Vijayawada'],
        ['IXR', 'Birsa Munda Airport', 'Ranchi'],
        ['TIR', 'Tirupati Airport', 'Tirupati'],
        ['RPR', 'Raipur Airport', 'Raipur'],
        ['IXB', 'Bagdogra Airport', 'Bagdogra'],
        ['LKO', 'Chaudhary Charan Singh International Airport', 'Lucknow'],
        ['ATQ', 'Sri Guru Ram Dass Jee International Airport', 'Amritsar'],
        ['TRV', 'Trivandrum International Airport', 'Thiruvananthapuram'],
        ['IXJ', 'Jammu Airport', 'Jammu'],
        # Add more Indian airports as needed
    ]
    return random.choice(indian_airports)

# Function to generate a random Indian airline
def get_random_indian_airline():
    indian_airlines = [
        'Air India',
        'IndiGo',
        'SpiceJet',
        'GoAir',
        'Vistara',
        'AirAsia India',
        'Air India Express',
        'Alliance Air',
        'TruJet',
        'Star Air',
        'Air Odisha',
        'Jet Airways',
        'Zoom Air',
        'Akasa Air',
        'FlyBig',
        # Add more Indian airlines as needed
    ]
    return random.choice(indian_airlines)

# Function to generate a random date
def random_date():
    start_date = datetime.date(2022, 1, 1)
    end_date = datetime.date(2024, 12, 31)
    delta = end_date - start_date
    random_days = random.randint(0, delta.days)
    return start_date + datetime.timedelta(days=random_days)

# Function to generate a random time
def random_time():
    return datetime.time(random.randint(0, 23), random.randint(0, 59))

# Function to generate a random flight duration
def random_flight_duration():
    hours = random.randint(1, 6)
    minutes = random.randint(0, 59)
    return f"{hours} hrs {minutes} mins"

# Function to generate random seat numbers based on aircraft model
def random_seat_numbers(plane_model):
    if "Boeing" in plane_model:
        economy_seats = random.randint(100, 300)
        business_seats = random.randint(20, 50)
        first_class_seats = random.randint(5, 15)
    elif "Airbus" in plane_model:
        economy_seats = random.randint(150, 350)
        business_seats = random.randint(30, 60)
        first_class_seats = random.randint(10, 20)
    else:
        # Default values
        economy_seats = random.randint(120, 280)
        business_seats = random.randint(25, 55)
        first_class_seats = random.randint(7, 17)
    return economy_seats, business_seats, first_class_seats

# Main function
def main():
    # Open CSV file for writing
    with open('generated_flight_data.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        # Write header row
        writer.writerow(['Plane ID', 'Plane Model', 'From Airport', 'From Date', 'From Time', 'To Airport', 'To Date', 'To Time', 'Flight Duration', 'Luggage Allowed', 'Economy Seats', 'Business Seats', 'First Class Seats'])

        # Generate and write flight data to CSV
        for _ in range(10000):  # Generate 10,000 rows
            airline_name = get_random_indian_airline()
            plane_code = random.randint(100, 999)
            plane_id = f"{airline_name}-{plane_code}"
            plane_model = random.choice(['Boeing 737', 'Boeing 747', 'Airbus A320', 'Airbus A321'])
            from_airport = get_random_indian_airport()
            to_airport = get_random_indian_airport()
            
            # Ensure departure and destination airports are not the same
            while from_airport == to_airport:
                to_airport = get_random_indian_airport()

            from_date = random_date().strftime("%d,%B,%Y")
            to_date = random_date().strftime("%d,%B,%Y")
            from_time = random_time().strftime("%I:%M %p")
            to_time = random_time().strftime("%I:%M %p")

            # Ensure from and to times are different
            while from_time == to_time:
                to_time = random_time().strftime("%I:%M %p")

            flight_duration = random_flight_duration()
            luggage_allowed = f"{random.randint(15, 30)} KG"

            # Generate random seat numbers
            economy_seats, business_seats, first_class_seats = random_seat_numbers(plane_model)

            writer.writerow([plane_id, plane_model, list(from_airport), from_date, from_time, list(to_airport), to_date, to_time, flight_duration, luggage_allowed, economy_seats, business_seats, first_class_seats])

    print("CSV file generated successfully.")

if __name__ == "__main__":
    main()
