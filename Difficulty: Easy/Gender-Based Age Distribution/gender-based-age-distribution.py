def median_age_by_gender(df):
    return df.groupby('gender', as_index=False)['age'].median().rename(columns={'age': 'median_age'})
