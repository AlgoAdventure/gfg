def mode_of_scores(df):
    result = df['score'].value_counts().reset_index()
    result.columns = ['score', 'mode']
    result = result.sort_values(by='mode', ascending=False).reset_index(drop=True)
    return result


    