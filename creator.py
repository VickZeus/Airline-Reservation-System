import csv
from random import randint, choice
from datetime import datetime, timedelta

# Dictionary of Indian airport codes and their full names
indian_airports = {
    'DEL': ('DEL', 'Indira Gandhi International Airport', 'New Delhi'),
    'BOM': ('BOM', 'Chhatrapati Shivaji Maharaj International Airport', 'Mumbai'),
    'BLR': ('BLR', 'Kempegowda International Airport', 'Bengaluru'),
    'MAA': ('MAA', 'Chennai International Airport', 'Chennai'),
    'CCU': ('CCU', 'Netaji Subhas Chandra Bose International Airport', 'Kolkata'),
    'HYD': ('HYD', 'Rajiv Gandhi International Airport', 'Hyderabad'),
    'AMD': ('AMD', 'Sardar Vallabhbhai Patel International Airport', 'Ahmedabad'),
    'COK': ('COK', 'Cochin International Airport', 'Kochi'),
    'GOI': ('GOI', 'Dabolim Airport', 'Goa'),
    'PNQ': ('PNQ', 'Pune Airport', 'Pune'),
    'ATQ': ('ATQ', 'Sri Guru Ram Dass Jee International Airport', 'Amritsar'),
    'IXC': ('IXC', 'Chandigarh International Airport', 'Chandigarh'),
    'JAI': ('JAI', 'Jaipur International Airport', 'Jaipur'),
    'LKO': ('LKO', 'Chaudhary Charan Singh International Airport', 'Lucknow'),
    'TRV': ('TRV', 'Trivandrum International Airport', 'Thiruvananthapuram'),
    'BBI': ('BBI', 'Biju Patnaik International Airport', 'Bhubaneswar'),
    'PAT': ('PAT', 'Jay Prakash Narayan International Airport', 'Patna'),
    'VGA': ('VGA', 'Vijayawada Airport', 'Vijayawada'),
    'IDR': ('IDR', 'Devi Ahilya Bai Holkar Airport', 'Indore'),
    'CJB': ('CJB', 'Coimbatore International Airport', 'Coimbatore'),
    'IXE': ('IXE', 'Mangalore International Airport', 'Mangalore'),
    'NAG': ('NAG', 'Dr. Babasaheb Ambedkar International Airport', 'Nagpur'),
    'IMF': ('IMF', 'Imphal International Airport', 'Imphal'),
    'DIB': ('DIB', 'Dibrugarh Airport', 'Dibrugarh'),
    'IXZ': ('IXZ', 'Veer Savarkar International Airport', 'Port Blair'),
}

# List of plane models
plane_models = {
    'A320': 'Airbus A320',
    'B737': 'Boeing 737',
    'A380': 'Airbus A380',
    # Add more plane models as needed
}

# List of flight prefixes
flight_prefixes = ['INDIGO', 'SPICEJET', 'AIR INDIA', 'GOAIR', 'EMIRATES', 'SINGAPORE AIRLINES', 'BRITISH AIRWAYS', 'TRUJET']

# Function to generate random airport code (Indian)
def generate_airport_code():
    return choice(list(indian_airports.keys()))

# Function to generate random airport details (code, name, location)
def generate_airport():
    code = generate_airport_code()
    name, location = indian_airports[code][1:]
    return code, name.upper(), location.upper()

# Function to generate random plane details (name, type)
def generate_plane():
    model_id = choice(list(plane_models.keys()))
    plane_type = plane_models[model_id]
    return f"{model_id} {plane_type}"

# Function to generate random flight name
def generate_flight_name():
    return choice(flight_prefixes) + '-' + str(randint(1000, 9999))

# Function to generate random departure and arrival times
def generate_random_time():
    return '{:02d}:{:02d}'.format(randint(0, 23), randint(0, 59))

# Function to generate random departure and arrival dates (1st June to 31st December)
def generate_random_date():
    start_date = datetime(2024, 6, 1)
    end_date = datetime(2024, 12, 31)
    return start_date + timedelta(days=randint(0, (end_date - start_date).days))

# Function to generate random luggage allowance
def generate_random_luggage_allowance():
    return randint(15, 40)

# Function to generate random seat arrangement
def generate_random_seat_arrangement():
    economy_seats = randint(100, 300)
    business_seats = randint(10, 50)
    luxury_seats = randint(1, 10)
    return f"{economy_seats} Economy, {business_seats} Business, {luxury_seats} Luxury"

# Function to generate flight records ensuring distinct destinations and times
def generate_flight_records(num_records):
    with open('flight_records.csv', mode='w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(['Flight Name', 'Plane', 'From Airport', 'Departure Time', 'Departure Date', 'To Airport', 'Arrival Time', 'Arrival Date', 'Luggage Allowed', 'Seat Arrangement'])
        
        for _ in range(num_records):
            flight_name = generate_flight_name()
            plane = generate_plane()
            from_code, from_name, from_location = generate_airport()
            to_code, to_name, to_location = generate_airport()
            while from_code == to_code or from_name == to_name or from_location == to_location:
                to_code, to_name, to_location = generate_airport()
            
            departure_time = generate_random_time()
            arrival_time = generate_random_time()
            while departure_time == arrival_time:
                arrival_time = generate_random_time()
            
            departure_date = generate_random_date()
            arrival_date = generate_random_date()
            while arrival_date <= departure_date:
                arrival_date = departure_date + timedelta(hours=randint(1, 12)) # Ensure arrival is after departure
            
            luggage_allowed = generate_random_luggage_allowance()
            seat_arrangement = generate_random_seat_arrangement()
            
            writer.writerow([
                flight_name,
                plane,
                f"{from_name} ({from_code})({from_location})",
                departure_time,
                departure_date.strftime('%d/%m/%Y'),
                f"{to_name} ({to_code})({to_location})",
                arrival_time,
                arrival_date.strftime('%d/%m/%Y'),
                luggage_allowed,
                seat_arrangement
            ])

# Generate 10,000 flight records
generate_flight_records(10000)
print("Flight records generated successfully!")
