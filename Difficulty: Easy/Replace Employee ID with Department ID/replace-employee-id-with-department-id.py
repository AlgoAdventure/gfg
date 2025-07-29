def find_department_id(df_employees, df_employee_dept):
    # Merge on 'id' with left join to keep all employees
    result = df_employees.merge(df_employee_dept, on='id', how='left')
    
    # Return only the required columns in correct order
    return result[['department_id', 'name']]

