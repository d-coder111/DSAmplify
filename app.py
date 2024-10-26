from flask import Flask, render_template, request
import os

app = Flask(__name__)


# default page
@app.route('/')
def index():
    return render_template('index.html')


# render home page
@app.route('/home')
def home():
    """ Reder home page """
    return render_template('index.html')


# render about page
@app.route('/about')
def about():
    """ Render about page"""
    return render_template('about.html')


@app.route('/language', methods=['POST'])
def language():
    """
    Fetch question name and file path based on the selected language and returns the home page with the questions information
    """
    language = request.form['language']
    solutions_dir = f"{language}/"

    questions = [] # list to store the information related to question
    for filename in os.listdir(solutions_dir):
        # question name would not contain underscore and extension
        question_name = filename.replace('_', ' ').replace('.cpp', '').replace('.java', '').replace('.py', '')
        questions.append({'name': question_name, 'file': filename})

    return render_template('index.html', questions=questions, language=language)


@app.route('/problem/<filename>')
def problem_solution(filename):
    """
    Read the solution code from the file and return the problem_solution.html page to show the solution code to user
    """
    # get the language which is passed as a parameter from the index.html
    language = request.args.get('language')

    if not language:
        return "Language not specified. Please select a language." # Error Message if no Language is selected
    
    file_path = f"{language}/{filename}" # Filepath

    with open(file_path, 'r') as f:
        code = f.read()

    question_name = filename.replace('_', ' ').replace('.cpp', '').replace('.java', '').replace('.py', '')

    return render_template('problem_solution.html', code=code, question_name=question_name)


if __name__ == '__main__':
    app.run(debug=True)