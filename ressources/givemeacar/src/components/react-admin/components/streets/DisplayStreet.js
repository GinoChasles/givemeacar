import {
    Datagrid, Filter, List, SearchInput, TextField, useTranslate
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayStreet = (props) => {

    const t = useTranslate()

    return <List {...props} title={t('word.streets')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.name')} source="name" />
        </Datagrid>
    </List>
}

export default DisplayStreet