/*
 * New class 
 * Includes score calculation for a throw and cumulative score for player
 * 
 */
public class ScoreUtil {

    private int curScore[];
    private int cumulScores[];
    private boolean done;
    private int current;
    
    public ScoreUtil(int[] curPlayerScore, int index) {
        cumulScores = new int[10];
        current = index - 2;
        curScore = curPlayerScore;
    }


    public void onNormalThrow(int i){
        if( i%2 == 0 && i < 18){
            if ( i/2 == 0 ) {
                if(curScore[i] != -2){
                    cumulScores[i/2] += curScore[i];
                }
            } else if (i/2 != 9){
                //Add cumul of last frame to this ball and cal curr cumulscore.
                if(curScore[i] != -2){
                    cumulScores[i/2] += cumulScores[i/2 - 1] + curScore[i];
                } else {
                    cumulScores[i/2] += cumulScores[i/2 - 1];
                }
            }
        } else if (i < 18){
            if(curScore[i] != -1){
                cumulScores[i/2] += curScore[i];

            }
        }
    }
    

    public void onStrike(int i)
    {
        if( curScore[i+4]!=-1 || (curScore[i + 2] != -1 && (curScore[i+3]!=-1))) {
            done = true;
            cumulScores[i / 2] += 10;
            if (curScore[i + 1] != -1) {
                cumulScores[i / 2] += curScore[i + 1] + cumulScores[(i / 2) - 1];
                if (curScore[i + 2] != -1) {
                    cumulScores[(i / 2)] += curScore[i + 2];

                } else {
                    if (curScore[i + 3] != -2) {
                        cumulScores[(i / 2)] += curScore[i + 3];
                    }
                }
            } else {
                if (i / 2 > 0) {
                    cumulScores[i / 2] += curScore[i + 2] + cumulScores[(i / 2) - 1];
                } else {
                    cumulScores[i / 2] += curScore[i + 2];
                }
                if (curScore[i + 3] != -1 && curScore[i + 3] != -2) {
                    cumulScores[(i / 2)] += curScore[i + 3];
                } else {
                    cumulScores[(i / 2)] += curScore[i + 4];
                }
            }
        }
    }


    public int[] getScores() {
    	
        for (int i = 0; i != current+2; i++)
        {
            done = false;
            if( i%2 == 1 && curScore[i - 1] + curScore[i] == 10 && i < current - 1 && i < 19){
                cumulScores[(i/2)] += curScore[i+1] + curScore[i];
                done = true;
            }
            
            if( i < current && i%2 == 0 && curScore[i] == 10  && i < 18){
                onStrike(i);
                if(!done) break;
            }

            else {
                onNormalThrow(i);
                if (i / 2 == 9) {
                    if (i == 18) {
                        cumulScores[9] += cumulScores[8];
                    }
                    cumulScores[9] += curScore[i];

                } else if (i / 2 == 10) {
                    cumulScores[9] += curScore[i];

                }
            }
        }
        
        return cumulScores;
    }

}
