import openai

# APIキーの設定
openai.api_key = "xxxxxxxxxx"

response = openai.ChatCompletion.create(
    model="gpt-3.5-turbo",
    messages=[
        {"role": "user",
         "content":
         "インプレスのすっきりわかる入門シリーズって、どんな本？"}
    ],
)

print(response.choices[0]["message"]["content"].strip())
