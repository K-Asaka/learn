# Raspberry Piから温湿度を取得して表示する
import RPi.GPIO as GPIO
import dht11
import time
import datetime

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
GPIO.cleanup()
instance = dht11.DHT11(pin=14)
while True:
    result = instance.read()
    if result.is_valid():
        temperature = result.temperature
        humidity = result.humidity
        print('温度:{}'.format(temperature))
        print('湿度:{}'.format(humidity))
    time.sleep(1)
