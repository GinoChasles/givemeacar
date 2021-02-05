import { Datagrid, Filter, List, TextField, SearchInput, useTranslate, EditButton, DeleteButton } from "react-admin";
import * as React from "react";

const ColorFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayColor = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.colors')} filters={<ColorFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show">


            <TextField label={t('word.name')} source="name" />


            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}
export default DisplayColor