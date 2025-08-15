import pandas as pd
import random
from faker import Faker
import numpy as np

# Initialize faker for generating fake data
fake = Faker('en_IN')  # Using Indian locale for more realistic names

# Set random seed for reproducibility
random.seed(42)
np.random.seed(42)

def generate_dataset(num_records=1000):
    # Define possible values for categorical fields
    categories = ['Open', 'OBC', 'SC', 'ST', 'NT', 'VJ']
    genders = ['Male', 'Female']
    pwd_options = ['Yes', 'No']
    minority_options = ['None', 'Religious Minority', 'Linguistic Minority']
    
    data = []
    
    for i in range(num_records):
        # Generate EN Number (8 digits)
        en_number = random.randint(10000000, 99999999)
        
        # Generate Indian name with surname_first format
        surname = fake.last_name()
        first_name = fake.first_name_male() if random.choice([True, False]) else fake.first_name_female()
        middle_name = fake.first_name()
        name = f"{surname}_{first_name}_{middle_name}"
        
        # Generate contact number
        contact = f"9{random.randint(100000000, 999999999)}"
        
        # Generate email
        email = f"{first_name.lower()}.{surname.lower()}@email.com"
        
        # Generate category and related fields
        category = random.choice(categories)
        gender = random.choice(genders)
        pwd = random.choices(pwd_options, weights=[0.05, 0.95])[0]  # 5% PWD
        ews = random.choices(pwd_options, weights=[0.1, 0.9])[0]  # 10% EWS
        tfws = random.choices(pwd_options, weights=[0.15, 0.85])[0]  # 15% TFWS
        orphan = random.choices(pwd_options, weights=[0.02, 0.98])[0]  # 2% Orphan
        minority = random.choice(minority_options)
        
        # Generate SSC marks (10th standard)
        ssc_english = round(random.uniform(70, 95), 1)
        ssc_maths = round(random.uniform(75, 98), 1)
        ssc_science = round(random.uniform(75, 95), 1)
        ssc_social = round(random.uniform(75, 90), 1)
        ssc_hindi = round(random.uniform(70, 90), 1)
        ssc_marathi = round(random.uniform(70, 90), 1)
        
        # Generate HSC marks (12th standard)
        hsc_english = round(random.uniform(65, 90), 1)
        hsc_physics = round(random.uniform(70, 92), 1)
        hsc_chemistry = round(random.uniform(70, 92), 1)
        hsc_maths = round(random.uniform(70, 95), 1)
        hsc_biology = round(random.uniform(65, 90), 1)
        
        # Generate MHTCET marks (out of 50)
        mhtcet_physics = round(random.uniform(35, 50), 1)
        mhtcet_chemistry = round(random.uniform(35, 50), 1)
        mhtcet_maths = round(random.uniform(35, 50), 1)
        
        # Generate DOB (students aged 17-19)
        dob_day = random.randint(1, 28)
        dob_month = random.randint(1, 12)
        dob_year = random.randint(2004, 2006)
        
        # Create record
        record = [
            en_number, name, contact, email, category, gender, pwd, ews, tfws, 
            orphan, minority, ssc_english, ssc_maths, ssc_science, ssc_social, 
            ssc_hindi, ssc_marathi, hsc_english, hsc_physics, hsc_chemistry, 
            hsc_maths, hsc_biology, mhtcet_physics, mhtcet_chemistry, mhtcet_maths,
            dob_day, dob_month, dob_year
        ]
        
        data.append(record)
    
    return data

def create_dataframe(data):
    columns = [
        'EN_Number', 'Name', 'Contact', 'Email', 'Category', 'Gender', 'PWD_DEF', 
        'EWS', 'TFWS', 'Orphan', 'Minority', 'SSC_English', 'SSC_Maths', 'SSC_Science', 
        'SSC_SocialStudies', 'SSC_Hindi', 'SSC_Marathi', 'HSC_English', 'HSC_Physics', 
        'HSC_Chemistry', 'HSC_Maths', 'HSC_Biology', 'MHTCET_Physics', 'MHTCET_Chemistry', 
        'MHTCET_Maths', 'DOB_Day', 'DOB_Month', 'DOB_Year'
    ]
    
    df = pd.DataFrame(data, columns=columns)
    return df

# Generate the dataset
print("Generating 1000 data points...")
dataset = generate_dataset(1000)
df = create_dataframe(dataset)

# Save to CSV
df.to_csv('student_dataset_1000.csv', index=False)

# Display basic information
print(f"Dataset generated with {len(df)} records")
print("\nFirst 5 records:")
print(df.head())

print("\nDataset summary:")
print(df.info())

print("\nCategory distribution:")
print(df['Category'].value_counts())

print("\nGender distribution:")
print(df['Gender'].value_counts())

print(f"\nDataset saved as 'student_dataset_1000.csv'")