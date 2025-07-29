def find_patients_with_hypertension(df):
    mask = df['conditions'].fillna('').apply(lambda x: x.split()[0] if x else '').str.startswith('HTN')
    return df.loc[mask, ['patient_id', 'patient_name', 'conditions']]

