def find_rank_scores(df):
    # Code here
    df['rank'] = df['score'].rank(method='min', ascending=False).astype(int)
    df = df.sort_values(by='score', ascending=False).reset_index(drop=True)
    return df