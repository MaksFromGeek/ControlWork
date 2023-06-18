from Models.Menu import menuOptions


def printMenu():
    """
    Функция отрисовки меню в консоль
    :return:
    """
    for key in menuOptions.keys():
        print(key, '≈', menuOptions[key])