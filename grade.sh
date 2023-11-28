CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

if [[ -f "student-submission/ListExamples.java" ]]
then
    echo "found"
else
    echo "File missing: ListExample.java"
fi

cp -r *.java */*.java grading-area


javac -cp $CPATH grading-area/*.java

if [[ $? == 0 ]]
then
    echo "---------------------"
    echo "Compiled successfully"
    echo "---------------------"
else
    echo "Compile error: Fail!!"
fi

java -cp ".:grading-area:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore TestListExamples > Final_Grade.txt

grep "Failures" Final_Grade.txt

grep "OK" Final_Grade.txt



# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
