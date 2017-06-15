# Test plan

## Manual tests

--------------------------------------------------------------------------------
*Test*         *Method*        *Expected*        *Actual*        *Evidence*
-------------- ------------- ----------------- --------------- -----------------
Selecting 10   Click 10      There will be     As expected     See figure
creates a quiz               10 questions                      \ref{fig:1}
with 10
questions


Selecting 20   Click 20      There will be     As expected     See figure
creates a quiz               20 questions                      \ref{fig:2}
with 20
questions


Selecting 30   Click 30      There will be     As expected     See figure
creates a quiz               30 questions                      \ref{fig:3}
with 30
questions


Cross on top   Click `x`     Quiz will go      As expected     See gif[^1]
left takes                   back to form
user back to
quiz creation

Selecting an   Select an     Next question     As expected     See gif[^2]
option brings  option        will come up
the next
question up

Skipping will  Skip a        The question      As expected     See gif[^3]
send the       question      will be skipped
question to                  and asked again
the end                      at the end of
                             the quiz

When the       Wait for      The quiz gets     As expected     See gif[^4]
timer runs     timer to run  submitted
out the quiz   out
gets submitted

Score is       Finish the     The score is     As expected     See figure
displayed as   quiz           displayed upon                   \ref{fig:4}
a percentage                  finishing the
                              quiz
--------------------------------------------------------------------------------

![10 Questions\label{fig:1}](report/images/00.png)

![20 Questions\label{fig:2}](report/images/01.png)

![30 Questions\label{fig:3}](report/images/02.png)

![Quiz result\label{fig:4}](report/images/03.png)

[^1]: http://www.giphy.com/gifs/3ohzdEZt9v5mq8oAsE
[^2]: http://www.giphy.com/gifs/3og0IMCTcnr7RFvaaQ
[^3]: http://www.giphy.com/gifs/l1BgSVSrual0DUzDi
[^4]: http://www.giphy.com/gifs/l0Iy8yTqqq5BCf1yU
