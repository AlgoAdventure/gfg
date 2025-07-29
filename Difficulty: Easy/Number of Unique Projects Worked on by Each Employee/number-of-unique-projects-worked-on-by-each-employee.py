def count_unique_projects(df):
    # Drop duplicates based on employee, project, and department
    unique_projects = df.drop_duplicates(subset=['employee_id', 'project_id', 'dept_id'])

    # Group by employee_id and count unique project-dept combinations
    result = unique_projects.groupby('employee_id').size().reset_index(name='cnt')

    return result
