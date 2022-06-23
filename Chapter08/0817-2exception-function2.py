def faulty():
    raise Exception('例外が発生しました。')

def ignore_exception():
    faulty()

def handle_exception():
    try:
        faulty()
    except:
        print('例外が処理されました。')

ignore_exception()
