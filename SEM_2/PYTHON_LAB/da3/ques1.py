def extract_date(sentence):
    date_separators = ['/', '-', '.']
    formats = ['%d/%m/%Y', '%d-%m-%Y', '%d.%m.%Y', '%d/%m/%y', '%d-%m-%y', '%d.%m.%y']

    sentence = sentence.replace('.', '')  # Remove periods to avoid conflicts

    words = sentence.split()
    for word in words:
        for separator in date_separators:
            if separator in word:
                parts = word.split(separator)
                if len(parts) == 3:
                    for date_format in formats:
                        try:
                            date = datetime.datetime.strptime(word, date_format).date()
                            # Format the date as desired (e.g., dd/mm/yyyy)
                            formatted_date = date.strftime('%d/%m/%Y')
                            return formatted_date
                        except ValueError:
                            pass

    return None

# Example usage
import datetime

sentence = "The event will take place on 25/03/2020. Don't forget to mark your calendar!"
Input=["The project deadline is set for 25-03-2020. Make sure to submit your work on time!",
"The release date of the highly anticipated movie is 12/05/2023. Get ready for an exciting cinematic experience!",
"The registration deadline for the competition is 30-06-23. Don't miss your chance to participate."]
for i in Input:
    date = extract_date(i)
    if date:
        print(f"Date found: {date}")
    else:
        print("No date found in the sentence.")