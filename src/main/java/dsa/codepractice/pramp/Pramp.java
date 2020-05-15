package dsa.codepractice.pramp;

public class Pramp {
    
    // function deletionDistance(str1, str2):
    // str1Len = str1.length
    // str2Len = str2.length
    
    // # allocate a 2D array with str1Len + 1 rows and str2Len + 1 columns
    // memo = new Array(str1Len + 1, str2Len + 1)

    // for i from 0 to str1Len:
    //     for j from 0 to str2Len:
    //         if (i == 0):
    //             memo[i][j] = j
    //         else if (j == 0):
    //             memo[i][j] = i
    //         else if (str1[i-1] == str2[j-1]):
    //             memo[i][j] = memo[i-1][j-1]
    //         else:
    //             memo[i][j] = 1 + min(memo[i-1][j], memo[i][j-1])

    // return memo[str1Len][str2Len]

    // function deletionDistance(str1, str2):
    // # make sure the length of str2 isn't
    // # longer than the length of str1
    // if (str1.length < str2.length)
    //     tmpStr = str1
    //     str1 = str2
    //     str2 = tmpStr

    // str1Len = str1.length
    // str2Len = str2.length
    // prevMemo = new Array(str2Len  + 1)
    // currMemo = new Array(str2Len  + 1)

    // for i from 0 to str1Len:
    //     for j from 0 to str2Len:
    //         if (i == 0):
    //             currMemo[j] = j
    //         else if (j == 0):
    //             currMemo[j] = i
    //         else if (str1[i-1] == str2[j-1]):
    //             currMemo[j] = prevMemo[j-1]
    //         else:
    //             currMemo[j] = 1 + min(prevMemo[j], currMemo[j-1])

    //     prevMemo = currMemo
    //     currMemo = new Array(str2Len + 1);  
                                           
    // return prevMemo[str2Len]
}