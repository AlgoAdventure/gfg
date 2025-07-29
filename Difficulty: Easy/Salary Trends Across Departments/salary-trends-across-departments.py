def average_salary_by_department(df):
    return df.groupby('department', as_index=False)['salary'].mean().rename(columns={'salary': 'average_salary'})
