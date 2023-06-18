from Views.GetMenu import printMenu
from Mechanisms.NoteOfMechanisms import NoteOfMechanisms
from Models.JsonNote import JsonModel
from Views.GetNote import View
from Models.Note import Note

import datetime


def startMenu():
    """
    Основная функция запуска программы.
    :return:
    """
    c = NoteOfMechanisms(JsonModel("notes.json"), View())
    while (True):
        print('Программа заметки:')
        printMenu()
        task = ''
        try:
            task = int(input('Введите от 1 до 7: '))
        except:
            print('Неверно введено число от 1 до 7')
        
        if task == 1: # Проверка введённого числа и запуск функции в основном фаиле
            print('\nСоздание заметки.')
            c.create_note(get_note_data())
        elif task == 2:
            print('\nПоказать заметку.')
            if c.notes_exist():
                c.show_note(int(get_number()))
        elif task == 3:
            if c.notes_exist():
                print('\nПоказать все заметки.')
                c.show_notes()
        elif task == 4:
            if c.notes_exist():
                print('\nРедактировать заметку.')
                updated_id = int(get_number())
                if c.note_id_exist(updated_id):
                    c.update_note(updated_id, get_note_data())
        elif task == 5:
            if c.notes_exist():
                print('\nУдалить заметку!')
                delete_id = int(get_number())
                if c.note_id_exist(delete_id):
                    c.delete_note(delete_id)
        elif task == 6:
            if c.notes_exist():
                print('Удалить все заметки!')
                if input('Вы уверены? (Y/N): ').capitalize() == 'Y':
                    if c.notes_exist():
                        c.delete_all_notes()
        elif task == 7:
            print('Выходим из программы')
            exit()
        else:
            print('Ошибка. Введите от 1 до 7.')


def get_note_data():
    note_id = 0
    date = datetime.datetime.now()
    title = input('Введите новое имя заметки: ')
    text = input('Введите новый текст заметки: ')
    return Note(note_id, date, title, text)


def get_number():
    while True:
        get_choice = input('Введите id заметки: ')
        if get_choice.isdigit() and int(get_choice) > 0:
            return get_choice
        else:
            print('\t\t\tВведено неверное id заметки!')