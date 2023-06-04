import re

def extract_date(sentence):
    date_regex = r'\b(\d{1,2})[-./](\d{1,2})[-./](\d{2}|\d{4})\b'
    matches = re.findall(date_regex, sentence)
    if matches:
        for match in matches:
            day = match[0]
            month = match[1]
            year = match[2]
            formatted_date = f'{day.zfill(2)}/{month.zfill(2)}/{year.zfill(4)}'
            return formatted_date
    return None

sentence = "The event will take place on 25/03/2020. Don't forget to mark your calendar!"
Input=["The project deadline is set for 25-03-2020. Make sure to submit your work on time!",
"Join us for a special event on 25.03.2020. Save the date!",
"The workshop will be held on 05.3.20. Register in advance to secure your spot.",
"The release date of the highly anticipated movie is 12/05/2023. Get ready for an exciting cinematic experience!",
"The registration deadline for the competition is 30-06-23. Don't miss your chance to participate.",
'05.3.20']
for i in Input:
    date = extract_date(i)
    if date:
        print(f"Date found: {date}")
    else:
        print("No date found in the sentence.")